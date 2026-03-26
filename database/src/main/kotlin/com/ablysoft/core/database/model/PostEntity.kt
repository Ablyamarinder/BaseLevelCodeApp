package com.ablysoft.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Defines an NiA news resource.
 */

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: Int = 0,
    val userId: Int,
    val title: String,
    val body: String
)
