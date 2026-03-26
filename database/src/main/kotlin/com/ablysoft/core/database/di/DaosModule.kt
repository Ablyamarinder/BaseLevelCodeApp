package com.ablysoft.core.database.di

import com.ablysoft.core.database.CustomDatabase
import com.ablysoft.core.database.dao.PostsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesPostsDao(
        database: CustomDatabase,
    ): PostsDao = database.postDao()

}
