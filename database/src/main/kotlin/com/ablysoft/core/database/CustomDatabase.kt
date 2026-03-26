package com.ablysoft.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ablysoft.core.database.dao.PostsDao
import com.ablysoft.core.database.model.Post
import com.ablysoft.core.database.util.InstantConverter

@Database(entities = [Post::class], version = 1, exportSchema = false)
@TypeConverters(InstantConverter::class)
abstract class CustomDatabase : RoomDatabase() {

    abstract fun postDao(): PostsDao
}
