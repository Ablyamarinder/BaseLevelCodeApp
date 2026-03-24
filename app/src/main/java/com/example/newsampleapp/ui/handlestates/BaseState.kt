package com.example.newsampleapp.ui.handlestates

// Define a sealed interface to represent the various states of the UI
sealed interface UiState<out T> {
    object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val errorMessage: String) : UiState<Nothing>
}
