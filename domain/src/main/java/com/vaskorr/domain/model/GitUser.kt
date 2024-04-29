package com.vaskorr.domain.model

import com.vaskorr.domain.model.GitRepository

data class GitUser(
    val username: String,
    val repositories: List<GitRepository>,
)
