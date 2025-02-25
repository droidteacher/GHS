package hu.zsoltkiss.githubsearch.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import hu.zsoltkiss.githubsearch.ui.theme.Pink80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GHSAppBar(screenTitle: String, navigationHandler: (() -> Unit)?) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Pink80,
            titleContentColor = Color.Black,
        ),
        title = {
            Text(
                screenTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = { appBarNavigationItem(handler = navigationHandler) }

    )
}

@Composable
fun appBarNavigationItem(handler: (() -> Unit)?) {
    if (handler != null) {
        IconButton(onClick = handler) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back navigation")
        }
    }
}



