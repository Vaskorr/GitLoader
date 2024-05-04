package com.vaskorr.gitloader.domain.model

enum class NetworkResponseStatus{
    SUCCESS, FAILED
}

data class NetworkResponse<T>(
    val status: NetworkResponseStatus,
    val body: T
)
