package com.example.newsampleapp.di

import com.example.newsampleapp.domain.repository.PostsRepository
import com.example.newsampleapp.ui.posts.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindPostRepository(newsRepositoryImpl: PostRepositoryImpl): PostsRepository
}