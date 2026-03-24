package com.example.newsampleapp.utils.networkutil

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<Status>

    val isConnected: Boolean

    sealed interface Status {
        object Available : Status
        object Unavailable : Status
        object Losing : Status
        object Lost : Status
    }
}