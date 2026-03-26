package com.ablysoft.sampleapp.di

import com.ablysoft.sampleapp.domain.repository.PostsRepository
import com.ablysoft.sampleapp.ui.posts.PostRepositoryImpl
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