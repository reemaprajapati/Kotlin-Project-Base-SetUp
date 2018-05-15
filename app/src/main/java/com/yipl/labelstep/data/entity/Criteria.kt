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

        @ColumnInfo(name = "show_wage_field")
        @SerializedName("show_wage_field")
        var isShowWageField: Boolean,

        @ColumnInfo(name = "show_figure_field")
        @SerializedName("show_figure_field")
        var isShowFigureField: Boolean,

        @ColumnInfo(name = "show_ls_rate")
        @SerializedName("show_ls_rate")
        var isShowLsRate: Boolean,

        @ColumnInfo(name = "show_legal_rate")
        @SerializedName("show_legal_rate")
        var isShowLegalRate: Boolean,

        @ColumnInfo(name = "standard_id")
        var standardId: Int
)
