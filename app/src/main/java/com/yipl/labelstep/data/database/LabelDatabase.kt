package com.yipl.labelstep.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.yipl.labelstep.data.dao.DatabaseDao
import com.yipl.labelstep.data.entity.*

@Database(entities = arrayOf(
        PostEntity::class,
        StandardsDataEntity::class,
        Criteria::class,
        SupplierDataEntity::class,
        UpcomingAudits::class),version = 1, exportSchema = false)
@TypeConverters(DataTypeConverter::class)
abstract class LabelDatabase: RoomDatabase(){
    abstract fun daoAccess() : DatabaseDao
}