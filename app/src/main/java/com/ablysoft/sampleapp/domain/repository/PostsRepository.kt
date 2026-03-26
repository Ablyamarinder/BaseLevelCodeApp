package com.ablysoft.sampleapp.domain.repository

import com.ablysoft.core.database.model.PostModel

interface PostsRepository {

    suspend fun getPosts() : Result<List<PostModel>>
    suspend fun savePosts(list: List<PostModel>)
}