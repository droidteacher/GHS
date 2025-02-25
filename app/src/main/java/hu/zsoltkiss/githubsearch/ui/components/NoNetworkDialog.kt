package hu.zsoltkiss.githubsearch.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import hu.zsoltkiss.githubsearch.ui.theme.warningDialogButton
import hu.zsoltkiss.githubsearch.ui.theme.warningDialogText
import hu.zsoltkiss.githubsearch.ui.theme.warningDialogTitle

@Composable
fun NoNetworkDialog() {
    AlertDialog(
        containerColor = Color.Gray,
        icon = {
            Icon(Icons.Default.Warning, contentDescription = "Warning icon", tint = Color.Yellow)
        },
        title = {
            Text(
                text = "Connection lost",
                style = warningDialogTitle
            )
        },
        text = {
            Text(
                text = "Device is offline. You won't be able to run your queries until connection is restored.",
                style = warningDialogText
            )
        },
        onDismissRequest = {},
        confirmButton = {}
    )
}