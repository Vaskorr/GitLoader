package com.vaskorr.gitloader.feature.search_repositories.internal.component.list

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.feature.search_repositories.internal.component.item.RepositoryItem
import java.net.URI
import java.net.URL


@Composable
internal fun RepositoryList(
    repositoryList: List<GitRepository>,
    onDownload: (GitRepository) -> Unit = {},
    onDelete: (GitRepository) -> Unit = {},
    isLocal: Boolean = false
) {
    val context = LocalContext.current
    LazyColumn {
        items(items = repositoryList, itemContent = {
            RepositoryItem(
                name = "${it.owner}/${it.label}",
                onWebOpen = {
                    val browser_url = it
                        .url.toString()
                        .replace("api.", "")
                        .replace("/repos", "")
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(browser_url))
                    ContextCompat.startActivity(context, browserIntent, null)
                },
                onDownload = { onDownload(it) },
                onDelete = { onDelete(it) },
                isLocal = isLocal
            )
        })
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
private fun SplashScreenPreview() {
    RepositoryList(
        repositoryList = listOf(
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("123", "ya", URL("http://vk.com"), URI("file://vk.com")),
            GitRepository("456", "ne ya", URL("http://vk.com"), URI("file://vk.com"))
        ), {}, {}
    )
}