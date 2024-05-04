package com.vaskorr.gitloader.feature.search_repositories.internal.component.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vaskorr.gitloader.core.R
import com.vaskorr.gitloader.core.theme.GitLoaderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChanged: (searchText: String) -> Unit,
    onTextClear: () -> Unit,
    onSearch: () -> Unit
) {
    TextField(
        searchText,
        onSearchTextChanged,
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        leadingIcon = { LeadingIcon(onSearch) },
        trailingIcon = { TrailingIcon() }
    )
}

@Composable
private fun LeadingIcon(
    onSearch: () -> Unit
) {
    IconButton(onClick = onSearch) {
        Icon(
            painter = painterResource(id = R.drawable.magnify),
            contentDescription = "icon"
        )
    }
}

@Composable
private fun TrailingIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.close),
            contentDescription = "icon"
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
fun SplashScreenPreview() {
    GitLoaderTheme {
        SearchTextField(
            "Calculator",
            {},
            {},
            {}
        )
    }
}