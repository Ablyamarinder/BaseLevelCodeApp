package com.example.newsampleapp.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.newsampleapp.data.model.PostModel
import com.example.newsampleapp.ui.handlestates.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel : LifecycleObserver, ViewModel() {

    // MutableStateFlow is used internally to update the state
    protected val _uiState =
        MutableStateFlow<UiState<List<PostModel>>>(UiState.Loading)

    // Expose an immutable StateFlow for the UI to observe
    val uiState: StateFlow<UiState<List<PostModel>>> = _uiState


}