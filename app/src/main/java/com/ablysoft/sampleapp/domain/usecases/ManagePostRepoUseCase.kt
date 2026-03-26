package com.ablysoft.sampleapp.domain.usecases

import com.ablysoft.core.database.model.PostModel
import com.ablysoft.sampleapp.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ManagePostRepoUseCase @Inject constructor(private val postRepo: PostsRepository) {

    fun getPosts(): Flow<Result<List<PostModel>>> {
        return flow {
            val response = postRepo.getPosts()
            emit(response)
        }
    }

    suspend fun savePosts(list: List<PostModel>) {
        postRepo.savePosts(list)
    }
}