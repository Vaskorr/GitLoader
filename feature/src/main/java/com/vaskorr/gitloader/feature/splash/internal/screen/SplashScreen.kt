package com.vaskorr.gitloader.feature.splash.internal.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vaskorr.gitloader.core.R
import com.vaskorr.gitloader.core.theme.GitLoaderTheme

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = stringResource(id = R.string.app_name)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    GitLoaderTheme {
        SplashScreen()
    }
}