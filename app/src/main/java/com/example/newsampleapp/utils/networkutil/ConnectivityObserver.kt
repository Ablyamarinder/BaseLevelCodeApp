package com.example.newsampleapp.utils.networkutil

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<Status>

    sealed interface Status {
        object Available : Status
        object Unavailable : Status
        object Losing : Status
        object Lost : Status
    }
}