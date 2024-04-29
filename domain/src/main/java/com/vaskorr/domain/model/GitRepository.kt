package com.vaskorr.domain.model

import java.net.URI
import java.net.URL

data class GitRepository (
    val label: String,
    val owner: String,
    val url: URL,
    val downloadedFileUri: URI?
)