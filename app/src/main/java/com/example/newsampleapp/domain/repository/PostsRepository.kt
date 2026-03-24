package com.example.newsampleapp.domain.repository

import com.example.newsampleapp.data.model.PostModel

public interface PostsRepository {

    suspend fun getPosts() : Result<List<PostModel>>
    suspend fun savePosts(list: List<PostModel>)
}