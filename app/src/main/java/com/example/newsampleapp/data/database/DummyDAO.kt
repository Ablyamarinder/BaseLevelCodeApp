package com.example.newsampleapp.data.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

class DummyDAO {

    @Entity(tableName = "posts")
    data class Post(
        @PrimaryKey val id: Int = 0,
        val userId: Int,
        val title: String,
        val body: String
    )

    @Dao
    interface PostsDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertPosts(user: List<Post>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertSinglePost(user: Post)

        @Query("SELECT * FROM posts")
        fun getAllPosts(): List<Post>
    }

}