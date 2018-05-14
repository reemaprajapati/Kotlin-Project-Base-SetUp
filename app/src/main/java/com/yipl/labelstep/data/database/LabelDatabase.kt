package com.yipl.labelstep.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yipl.labelstep.data.dao.DatabaseDao
import com.yipl.labelstep.data.entity.PostEntity

@Database(entities = arrayOf(PostEntity::class),version = 1, exportSchema = false)
abstract class LabelDatabase: RoomDatabase(){
    abstract fun daoAccess() : DatabaseDao
}