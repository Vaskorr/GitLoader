package com.vaskorr.gitloader.feature.search_repositories.api.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vaskorr.gitloader.feature.search_repositories.internal.screen.downloads_screen.DownloadsScreen
import com.vaskorr.gitloader.feature.search_repositories.internal.screen.search_screen.SearchScreen

@Composable
fun FeatureNavController(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "search_repositories"
    ) {
        composable("search_repositories") {
            SearchScreen()
        }
        composable("downloaded_repositories") {
            DownloadsScreen()
        }
    }
}