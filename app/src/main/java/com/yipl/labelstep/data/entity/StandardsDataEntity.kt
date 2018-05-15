package com.yipl.labelstep.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "standards")
data class StandardsDataEntity(
        @SerializedName("standard_id")
        @PrimaryKey
        @ColumnInfo(name = "id")
       var id: Int,
        @ColumnInfo(name="standard_index")
        var code: Int,
        @ColumnInfo
        var name: String
) {
    @Ignore
    @SerializedName("criteria_list")
    lateinit var criteriaList: List<Criteria>
}






