package hu.zsoltkiss.githubsearch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import hu.zsoltkiss.githubsearch.data.model.RepositoryDetails
import hu.zsoltkiss.githubsearch.ui.theme.detailsLabel
import hu.zsoltkiss.githubsearch.ui.theme.detailsValue
import hu.zsoltkiss.githubsearch.ui.theme.hyperlink

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BoxScope.detailsSheet(repositoryDetails: RepositoryDetails?, noDataPlaceHolder: String, onWebPageNavigation: (String?) -> Unit) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(all = 8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            GlideImage(
                model = repositoryDetails?.avatarUrl,
                contentDescription = "Repository owner avatar"
            )
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Name", style = detailsLabel)
            Text(repositoryDetails?.repositoryName ?: noDataPlaceHolder, style = detailsValue)
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Description", style = detailsLabel)
            Text(
                repositoryDetails?.repositoryDescription ?: noDataPlaceHolder,
                style = detailsValue
            )
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Owner", style = detailsLabel)
            Text(repositoryDetails?.ownerName ?: noDataPlaceHolder, style = detailsValue)
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Owner page", style = detailsLabel)
            Text( repositoryDetails?.profileUrl ?: noDataPlaceHolder, style = hyperlink, modifier = Modifier.clickable {
                onWebPageNavigation(repositoryDetails?.profileUrl)
            })
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Repository page", style = detailsLabel)
            Text( repositoryDetails?.repositoryUrl ?: noDataPlaceHolder, style = hyperlink, modifier = Modifier.clickable {
                onWebPageNavigation(repositoryDetails?.repositoryUrl)
            })
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Stars", style = detailsLabel)
            Text(
                repositoryDetails?.starCount?.toString() ?: noDataPlaceHolder,
                style = detailsValue
            )
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Forks", style = detailsLabel)
            Text(
                repositoryDetails?.forkCount?.toString() ?: noDataPlaceHolder,
                style = detailsValue
            )
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Created at", style = detailsLabel)
            Text(repositoryDetails?.createdAt ?: noDataPlaceHolder, style = detailsValue)
        }
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Updated at", style = detailsLabel)
            Text(repositoryDetails?.updatedAt ?: noDataPlaceHolder, style = detailsValue)
        }
    }
}
