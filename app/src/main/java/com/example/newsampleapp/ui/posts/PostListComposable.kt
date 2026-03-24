package com.example.newsampleapp.ui.posts

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.newsampleapp.R
import com.example.newsampleapp.data.model.PostModel
import com.example.newsampleapp.utils.TextUtils


@Composable
fun PostListComposable(list: List<PostModel>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list.size) { index ->
            PostItemComposable(list[index])
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
                color = MaterialTheme.colorScheme.primary,
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
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.size_15)))
            Text(
                modifier = Modifier.padding(dimensionResource(R.dimen.size_5)),
                text = TextUtils.capitalizeText(item.body),
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}