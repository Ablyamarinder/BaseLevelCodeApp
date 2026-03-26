package com.example.newsampleapp.ui.posts

import com.ablysoft.core.database.dao.PostsDao
import com.ablysoft.core.database.model.PostModel
import com.ablysoft.core.database.model.toPost
import com.ablysoft.core.database.model.toPostModel
import com.example.newsampleapp.data.service.ApiService
import com.example.newsampleapp.domain.repository.PostsRepository
import com.example.newsampleapp.utils.networkutil.ConnectivityObserver
import javax.inject.Inject
import kotlin.collections.isNotEmpty
import kotlin.collections.map

class PostRepositoryImpl @Inject constructor(
    private val postDao: PostsDao,
    private val apiService: ApiService,
    private val connectivityObserver: ConnectivityObserver,
) : PostsRepository {

    override suspend fun getPosts(): Result<List<PostModel>> {
        return if (connectivityObserver.isConnected) {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception(response.message()))
            }
        } else {
            val localPosts = postDao.getAllPosts().map { it.toPostModel() }
            if (localPosts.isNotEmpty()) {
                Result.success(localPosts)
            } else {
                Result.failure(Exception("No internet connection"))
            }
        }

    }

    override suspend fun savePosts(list: List<PostModel>) {
        if (list.isNotEmpty()) {
            postDao.insertPosts(list.map { it.toPost() })
        }
    }
}