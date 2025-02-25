package hu.zsoltkiss.githubsearch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.zsoltkiss.githubsearch.data.model.RepositoryItem
import hu.zsoltkiss.githubsearch.ui.theme.Purple80
import hu.zsoltkiss.githubsearch.ui.theme.cardDescriptionStyle
import hu.zsoltkiss.githubsearch.ui.theme.cardTitleStyle
import hu.zsoltkiss.githubsearch.ui.theme.popularityIconTintColor

fun LazyListScope.repositoriesList(
    repos: List<RepositoryItem>,
    onCardSelect: (Long) -> Unit
) {
    items(repos) { aRepo ->
        RepositoryCard(
            repoId = aRepo.id,
            name = aRepo.name,
            description = aRepo.description,
            starCount = aRepo.stargazersCount,
            updatedAt = aRepo.updatedAt,
            onSelect = onCardSelect
        )
    }
}

@Composable
fun RepositoryCard(
    repoId: Long,
    name: String,
    description: String?,
    starCount: Long,
    updatedAt: String?,
    onSelect: (Long) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Purple80
        ),
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onSelect(repoId)
            }
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    style = cardTitleStyle,
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = description ?: "n/a",
                    style = cardDescriptionStyle,
                    modifier = Modifier.weight(0.3f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Star icon",
                    tint = popularityIconTintColor
                )
                Text(text = starCount.toString())
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = updatedAt ?: "", modifier = Modifier.weight(0.3f))
            }


        }
    }
}




