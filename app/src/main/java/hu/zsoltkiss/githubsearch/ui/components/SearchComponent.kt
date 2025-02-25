package hu.zsoltkiss.githubsearch.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchComponent(modifier: Modifier, onComplete: (String) -> Unit) {

    var searchExpression by remember {
        mutableStateOf("")
    }

    var active by remember {
        mutableStateOf(false)
    }

    SearchBar(
        modifier = modifier,
        query = searchExpression,
        onQueryChange = {
            searchExpression = it
        }, onSearch = {
            onComplete(it)
            active = false
            Log.d("7777", "search expression from text field: $it")
        }, active = active, onActiveChange = {
            active = it
        },
        placeholder = {
            Text(text = "e.g. github in:name user:EvanLi")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
        },
        trailingIcon = {
            if (active) {
                Icon(modifier = Modifier.clickable {
                    if (searchExpression.isNotEmpty()) {
                        searchExpression = ""
                    } else {
                        active = false
                    }

                }, imageVector = Icons.Default.Close, contentDescription = "Clear search")
            }


        },
        content = {}
    )
}