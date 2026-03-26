package com.ablysoft.core.database.model



// Mapper.kt file
fun Post.toPostModel(): PostModel {
    return PostModel(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}

// Mapper.kt file
fun PostModel.toPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}
