package com.yipl.labelstep.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "criteria")
data class Criteria(

        @SerializedName("criteria_id")
        @PrimaryKey
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo
        var code: String,

        @ColumnInfo
        var name: String,

        @ColumnInfo
        @SerializedName("show_wage_field")
        var isShowWageField: Boolean,

        @ColumnInfo
        @SerializedName("show_figure_field")
        var isShowFigureField: Boolean,

        @ColumnInfo
        @SerializedName("show_ls_rate")
        var isShowLsRate: Boolean,

        @ColumnInfo
        @SerializedName("show_legal_rate")
        var isShowLegalRate: Boolean)