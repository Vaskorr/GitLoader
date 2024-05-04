package com.vaskorr.gitloader.feature.search_repositories.internal.screen.splash_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Text(
        text = "GitLoader"
    )
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}