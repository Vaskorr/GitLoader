package com.vaskorr.gitloader.feature.search_repositories.internal.screen.splash_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vaskorr.gitloader.R
import com.vaskorr.gitloader.ui.theme.GitLoaderTheme

@Composable
fun SplashScreen() {
    Text(
        text = stringResource(
            id = R.string.app_name
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    com.vaskorr.gitloader.ui.theme.GitLoaderTheme {
        SplashScreen()
    }
}