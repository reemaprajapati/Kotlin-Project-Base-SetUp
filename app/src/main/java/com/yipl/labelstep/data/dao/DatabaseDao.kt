package com.yipl.labelstep.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import com.yipl.labelstep.data.entity.StandardsDataEntity
import com.yipl.labelstep.data.entity.StandardsEntity

@Dao
interface DatabaseDao{
//    @Query("SELECT * from post")
//    fun selectAll() : LiveData<List<Post>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertPosts(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStandard(standardsDataEntity: StandardsDataEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertCriteria(criteria: StandardsDataEntity.Criteria)
}