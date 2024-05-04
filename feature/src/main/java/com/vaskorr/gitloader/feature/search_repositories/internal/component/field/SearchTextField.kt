package com.vaskorr.gitloader.feature.search_repositories.internal.component.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vaskorr.gitloader.ui.theme.GitLoaderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChanged: (searchText: String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(100.dp),
        modifier = Modifier
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = onSearchTextChanged,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
fun SplashScreenPreview() {
    com.vaskorr.gitloader.ui.theme.GitLoaderTheme {
        SearchTextField(
            "Calculator",
            {}
        )
    }
}