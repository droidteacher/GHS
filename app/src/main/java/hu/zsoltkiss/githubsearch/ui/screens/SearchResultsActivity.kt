package hu.zsoltkiss.githubsearch.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hu.zsoltkiss.githubsearch.ui.components.GHSAppBar
import hu.zsoltkiss.githubsearch.ui.components.NoNetworkDialog
import hu.zsoltkiss.githubsearch.ui.components.SearchComponent
import hu.zsoltkiss.githubsearch.ui.components.repositoriesList
import hu.zsoltkiss.githubsearch.ui.theme.GitHubSearchTheme
import hu.zsoltkiss.githubsearch.ui.theme.Pink80
import hu.zsoltkiss.githubsearch.ui.theme.Purple80
import hu.zsoltkiss.githubsearch.ui.theme.noResults
import hu.zsoltkiss.githubsearch.ui.theme.searchError
import hu.zsoltkiss.githubsearch.ui.vm.SearchResultsViewModelImpl
import java.io.Serializable

class SearchResultsActivity : ComponentActivity() {
    private val viewModel: SearchResultsViewModelImpl by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val processing by viewModel.processing
            val repos by viewModel.repositoriesFetched
            val errorMessage by viewModel.apiError

            GitHubSearchTheme {
                if (viewModel.offline.value && viewModel.shouldShowDialog.value) {
                    NoNetworkDialog()
                }

                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Pink80), topBar = {
                    GHSAppBar(screenTitle = "Browse GitHub repos", navigationHandler = null)

                }) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.Gray)
                            .fillMaxSize()
                    ) {
                        SearchComponent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 8.dp
                                )
                                .align(Alignment.TopCenter),
                            onComplete = viewModel::applyQueryString
                        )

                        if (processing) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(32.dp)
                                    .align(Alignment.Center)
                                    .padding(top = 50.dp), color = Purple80
                            )
                        } else {
                            if (repos.isEmpty()) {
                                Text(
                                    text = "No results",
                                    style = noResults,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(top = 50.dp)
                                )
                            } else if (errorMessage != null) {
                                Text(
                                    text = errorMessage!!,
                                    style = searchError,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(top = 50.dp)
                                )
                            } else {
                                LazyColumn(
                                    modifier = Modifier.align(Alignment.Center).padding(top = 100.dp)
                                ) {

                                    repositoriesList(
                                        repos = repos,
                                        onCardSelect = ::loadDetails
                                    )
                                }
                            }
                        }
                    }


                }
            }
        }
    }

    private fun loadDetails(repoId: Long) {
       viewModel.getRepositoryDetailsById(repoId)?.let { details ->
            Intent(this, RepositoryDetailsActivity::class.java).also {
                it.putExtra("repoDetails", details as Serializable)
            }
        }?.let {detailsScreenIntent ->
            detailsScreenIntent.also {
                startActivity(it)
            }
       }
    }
}





