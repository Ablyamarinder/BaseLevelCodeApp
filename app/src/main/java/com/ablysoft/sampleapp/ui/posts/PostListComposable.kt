package com.ablysoft.sampleapp.ui.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.ablysoft.core.R
import com.ablysoft.core.database.model.PostModel
import com.ablysoft.core.designsystem.theme.CustomAppTheme
import com.ablysoft.sampleapp.ui.handlestates.UiState
import com.ablysoft.sampleapp.utils.TextUtils
import com.ablysoft.sampleapp.utils.toastutils.ToastUtils

@Composable
fun PostListComposable(postViewModel: PostViewModel = hiltViewModel()) {
    val state by postViewModel.uiState.collectAsState()
    PostListContent(state = state)
}

@Composable
fun PostListContent(state: UiState<List<PostModel>>) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (state) {
            is UiState.Loading -> {
                CircularProgressIndicator(color = colorResource(R.color.primary))
            }

            is UiState.Success -> {
                val list = state.data
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(list.size) { index ->
                        PostItemComposable(list[index])
                    }
                }
            }

            is UiState.Error -> {
                ToastUtils.showLongToast(
                    context,
                    state.errorMessage
                )
            }
        }
    }
}

@Composable
fun PostItemComposable(item: PostModel) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.size_15))
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(dimensionResource(R.dimen.size_10))
            )
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.size_10))
        ) {
            Text(
                modifier = Modifier.padding(dimensionResource(R.dimen.size_10)),
                text = TextUtils.capitalizeText(item.title),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.size_15)))
            Text(
                modifier = Modifier.padding(dimensionResource(R.dimen.size_5)),
                text = TextUtils.capitalizeText(item.body),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostComposablePreview() {
    CustomAppTheme {
        // Mocking the state for the preview to avoid ViewModel instantiation issues
        val mockPosts = listOf(
            PostModel(id = 1, userId = 1, title = "Sample Title 1", body = "Sample Body 1"),
            PostModel(id = 2, userId = 1, title = "Sample Title 2", body = "Sample Body 2")
        )
        PostListContent(state = UiState.Success(mockPosts))
    }
}