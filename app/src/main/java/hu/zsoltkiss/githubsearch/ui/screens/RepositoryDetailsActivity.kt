package hu.zsoltkiss.githubsearch.ui.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hu.zsoltkiss.githubsearch.data.model.RepositoryDetails
import hu.zsoltkiss.githubsearch.ui.components.GHSAppBar
import hu.zsoltkiss.githubsearch.ui.components.detailsSheet
import hu.zsoltkiss.githubsearch.ui.theme.GitHubSearchTheme

class RepositoryDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositoryDetails = intent.extras?.getSerializable("repoDetails") as? RepositoryDetails
        val noData = "n/a"

        enableEdgeToEdge()
        setContent {
            GitHubSearchTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        GHSAppBar(screenTitle = "Repository details", navigationHandler = ::navigateBack)
                    },
                    content = { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .background(Color.Gray)
                                .fillMaxSize()
                        ) {
                            detailsSheet(
                                repositoryDetails = repositoryDetails,
                                noDataPlaceHolder = noData,
                                onWebPageNavigation = ::displayWebPage
                            )
                        }
                    })
            }
        }
    }

    private fun displayWebPage(url: String?) {
        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }.also { browserIntent ->
            startActivity(browserIntent)
        }
    }

    private fun navigateBack() {
        onBackPressed()
    }

}