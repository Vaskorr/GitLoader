package com.vaskorr.gitloader.domain.model

data class GitUser(
    val username: String,
    val repositories: List<GitRepository>,
)
