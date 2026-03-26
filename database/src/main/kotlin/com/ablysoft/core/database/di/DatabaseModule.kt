package com.ablysoft.core.database.di

import android.content.Context
import androidx.room.Room
import com.ablysoft.core.database.CustomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesCustomDatabase(
        @ApplicationContext context: Context,
    ): CustomDatabase = Room.databaseBuilder(
        context,
        CustomDatabase::class.java,
        "custom-database",
    ).build()
}
