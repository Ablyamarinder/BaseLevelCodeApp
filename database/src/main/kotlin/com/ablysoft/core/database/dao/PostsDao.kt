package com.ablysoft.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ablysoft.core.database.model.Post


/**
 * DAO for [Posts] and [PostEntity] access
 */
@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(user: List<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSinglePost(user: Post)

    @Query("SELECT * FROM posts")
    fun getAllPosts(): List<Post>
}

