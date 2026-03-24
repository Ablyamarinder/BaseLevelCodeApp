package com.example.newsampleapp.ui.posts

import com.example.newsampleapp.data.database.DummyDAO
import com.example.newsampleapp.data.model.PostModel
import com.example.newsampleapp.data.service.ApiService
import com.example.newsampleapp.domain.repository.PostsRepository
import com.example.newsampleapp.utils.networkutil.NetworkViewModel
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiService: ApiService, val networkViewModel: NetworkViewModel, postDao: DummyDAO.PostsDao): PostsRepository {

    override suspend fun getPosts(): Result<List<PostModel>> {
        val response = apiService.getPosts()
//        val networkStatus = networkViewModel.networkStatus.value
  //      AppLog.d("Network Status: $networkStatus")

        return if(response.isSuccessful) {
            Result.success(/*response.body() ?:*/ emptyList())
        } else {
            Result.failure(Exception(response.message()))
        }
    }

    override suspend fun savePosts(list: List<PostModel>) {

    }
}