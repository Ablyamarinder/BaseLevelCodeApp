package com.example.newsampleapp.ui.posts

import androidx.lifecycle.viewModelScope
import com.example.newsampleapp.domain.usecases.ManagePostRepoUseCase
import com.example.newsampleapp.ui.BaseViewModel
import com.example.newsampleapp.ui.handlestates.UiState
import com.example.newsampleapp.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUseCase: ManagePostRepoUseCase,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel() {

    init {
        loadArticles()
    }

    fun loadArticles() {
        // Use a coroutine scope to perform the suspend function call
        viewModelScope.launch(dispatcherProvider.io) {
            _uiState.value = UiState.Loading
            try {
                val posts = postUseCase.getPosts()

                posts.catch { e ->
                    // Handle exceptions in the flow
                    _uiState.value = UiState.Error(e.toString())
                }.collect { resultList ->
                        // Collect the final result and update the StateFlow value
                        _uiState.value = UiState.Success(resultList)
                    }
            } catch (e: Exception) {
                // Handle exceptions outside the flow (e.g., initial setup issues)
                _uiState.value = UiState.Error(e.toString())

            }
        }
    }
}
