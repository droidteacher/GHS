package hu.zsoltkiss.githubsearch.ui.vm

import android.net.ConnectivityManager
import android.net.Network
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import hu.zsoltkiss.githubsearch.data.api.GitHubApi
import hu.zsoltkiss.githubsearch.data.model.RepositoryDetails
import hu.zsoltkiss.githubsearch.data.model.RepositoryItem
import hu.zsoltkiss.githubsearch.service.ConnectivityManagerWrapper
import hu.zsoltkiss.githubsearch.util.debugPrint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Timer
import kotlin.concurrent.timerTask

class SearchResultsViewModelImpl : ViewModel(), SearchResultsViewModel {

    private var apiService: GitHubApi

    override val processing: MutableState<Boolean> = mutableStateOf(false)
    override val offline: MutableState<Boolean> = mutableStateOf(false)
    override val shouldShowDialog: MutableState<Boolean> = mutableStateOf(false)
    override val searchExpression: MutableState<String> = mutableStateOf("")
    override val apiError: MutableState<String?> = mutableStateOf(null)

    override val repositoriesFetched: MutableState<List<RepositoryItem>> = mutableStateOf(emptyList())

    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.IO)

    init {
        val gitHubApiUrl = "https://api.github.com/"

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        val retrofit: Retrofit = Retrofit.Builder().client(client).addConverterFactory(GsonConverterFactory.create()).baseUrl(
            gitHubApiUrl).build()
        apiService = retrofit.create(GitHubApi::class.java)

        Timer().schedule(timerTask {
            subscribeForConnectivity()
        }, 4000)


    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
        ConnectivityManagerWrapper.getInstance().unsubscribe()
    }

    private fun subscribeForConnectivity() {
        ConnectivityManagerWrapper.getInstance().subscribe(object:
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                offline.value = false
                debugPrint("Connectivity status: ONLINE", "__VM__", 9999)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                shouldShowDialog.value = true
                offline.value = true
                debugPrint("Connectivity status: OFFLINE", "__VM__", 9999)
            }
        })
    }

    override fun applyQueryString(query: String) {
        searchExpression.value = query
        if (searchExpression.value.isNotEmpty()) {
            if (!offline.value) {
                processing.value = true
                scope.launch {

                    try {
                        val response = apiService.getRepositoriesByQuery(searchExpression.value)
                        debugPrint("5555 __VM__ ::searchForRepositories, response: $response, status code: ${response.code()}")

                        if (response.isSuccessful) {
                            response.body()?.let {
                                withContext(Dispatchers.Main) {
                                    repositoriesFetched.value = it.items
                                    processing.value = false
                                    apiError.value= null
                                }
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                processing.value = false
                                apiError.value= "Repository does not exist"
                            }

                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    override fun getRepositoryDetailsById(repoId: Long): RepositoryDetails? {
        return repositoriesFetched.value.firstOrNull { anItem -> anItem.id == repoId }?.let { selectedItem ->
            RepositoryDetails(
                repositoryId = selectedItem.id,
                repositoryName = selectedItem.name,
                repositoryDescription = selectedItem.description,
                repositoryUrl = selectedItem.htmlURL,
                ownerName = selectedItem.owner.login,
                avatarUrl = selectedItem.owner.avatarURL,
                profileUrl = "https://github.com/${selectedItem.owner.login}",
                starCount = selectedItem.stargazersCount,
                forkCount = selectedItem.forksCount,
                createdAt = selectedItem.createdAt,
                updatedAt = selectedItem.updatedAt
            )
        }
    }
}