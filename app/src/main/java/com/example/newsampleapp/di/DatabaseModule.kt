package com.example.newsampleapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsampleapp.data.database.AppDatabase
import com.example.newsampleapp.data.database.DummyDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton // Ensures only one instance of the database is created
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePostDao(database: AppDatabase): DummyDAO.PostsDao {
        return database.postDao()
    }
}