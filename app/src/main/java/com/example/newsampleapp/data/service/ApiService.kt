package com.example.newsampleapp.data.service

import com.ablysoft.core.database.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<PostModel>>
}