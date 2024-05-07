package com.vaskorr.gitloader.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.vaskorr.gitloader.core.R
import com.vaskorr.gitloader.core.theme.GitLoaderTheme
import com.vaskorr.gitloader.feature.search_repositories.api.navigation.FeatureNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            GitLoaderTheme {
                Scaffold(
                    bottomBar = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .background(MaterialTheme.colorScheme.background),
                        ) {
                            IconButton(
                                onClick = { navController.navigate("search_repositories") },
                                modifier = Modifier.weight(0.5f)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.folder_search_outline),
                                    contentDescription = "icon"
                                )
                            }
                            Divider(
                                modifier = Modifier
                                    .width(2.dp)
                                    .fillMaxHeight(),
                                color = MaterialTheme.colorScheme.secondary
                            )
                            IconButton(
                                onClick = { navController.navigate("downloaded_repositories") },
                                modifier = Modifier.weight(0.5f)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.folder_download_outline),
                                    contentDescription = "icon"
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
                {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                bottom = it.calculateBottomPadding()
                            )
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.background
                        ) {
                            FeatureNavController(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GitLoaderTheme {
        Greeting("Android")
    }
}