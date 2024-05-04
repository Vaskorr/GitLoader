package com.vaskorr.gitloader.domain.model

import com.vaskorr.gitloader.domain.model.GitRepository

data class GitUser(
    val username: String,
    val repositories: List<GitRepository>,
)
