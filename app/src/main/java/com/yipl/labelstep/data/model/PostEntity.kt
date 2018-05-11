package com.yipl.labelstep.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "post")
data  class PostEntity(
        @ColumnInfo(name = "userId") var userId: Int,
        @PrimaryKey @ColumnInfo(name = "id") var id: Int,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "body") var body: String
        )

