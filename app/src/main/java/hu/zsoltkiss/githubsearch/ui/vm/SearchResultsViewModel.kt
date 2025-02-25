package hu.zsoltkiss.githubsearch.ui.vm

import androidx.compose.runtime.MutableState
import hu.zsoltkiss.githubsearch.data.model.RepositoryDetails
import hu.zsoltkiss.githubsearch.data.model.RepositoryItem

interface SearchResultsViewModel {

    val processing: MutableState<Boolean>
    val offline: MutableState<Boolean>
    val shouldShowDialog: MutableState<Boolean>
    val searchExpression: MutableState<String>
    val apiError: MutableState<String?>
    val repositoriesFetched: MutableState<List<RepositoryItem>>

    fun applyQueryString(query: String)
    fun getRepositoryDetailsById(repoId: Long): RepositoryDetails?
}