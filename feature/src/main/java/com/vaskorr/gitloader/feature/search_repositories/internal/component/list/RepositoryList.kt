package com.vaskorr.gitloader.feature.search_repositories.internal.component.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vaskorr.gitloader.domain.model.GitRepository
import com.vaskorr.gitloader.feature.search_repositories.internal.component.item.RepositoryItem
import java.net.URI
import java.net.URL


@Composable
fun RepositoryList(
    repositoryList: List<GitRepository>,
    onWebOpen: (url: URL) -> Unit,
    onDownload: (GitRepository) -> Unit
) {
    LazyColumn {
        items(items = repositoryList, itemContent = {
            RepositoryItem(
                name = "${it.owner}/${it.label}",
                onWebOpen = { onWebOpen(it.url) },
                onDownload = { onDownload(it) })
        })
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 700)
@Composable
fun SplashScreenPreview() {
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