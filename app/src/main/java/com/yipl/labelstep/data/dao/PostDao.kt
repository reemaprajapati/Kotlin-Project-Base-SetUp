package com.yipl.labelstep.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.yipl.labelstep.data.model.Post
import com.yipl.labelstep.data.model.PostEntity

@Dao
interface PostDao{
    @Query("SELECT * from post")
    fun selectAll() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(post: PostEntity)

}