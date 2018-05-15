package com.yipl.labelstep.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.yipl.labelstep.data.Database
import java.util.*

/**
 * Created by rakeeb on 12/5/16.
 */
@Entity(tableName = "supplier")
data class SupplierDataEntity(
        @PrimaryKey
        @ColumnInfo
        var id: Int,

        @ColumnInfo
        var name: String,

        @ColumnInfo
        var code: String,

        @ColumnInfo
        var category: String,

        @ColumnInfo(name = "type")
        @SerializedName("supplier_type")
        var type: String,

        @ColumnInfo(name = "location")
        var location: Location,

        @ColumnInfo
        @SerializedName("contact_person")
        var contactPersonList: List<ContactPerson>,

        @ColumnInfo
        @SerializedName("contact_no")
        var contactNumberList: ArrayList<String>) {

    @Ignore
    @SerializedName("upcoming_schedules")
    lateinit var upcomingAuditList: List<UpcomingAudits>
}

class ContactPerson {
    lateinit var name: String
    lateinit var designation: String
    lateinit var email: String
    lateinit var telephone: String
    lateinit var mobileNumber: String
}


class Location {

    @SerializedName("lat")
    lateinit var latitude: String

    @SerializedName("long")
    lateinit var longitude: String
}

@Entity(tableName = "upcoming_audit")
class UpcomingAudits(

        @PrimaryKey(autoGenerate = true)
        var rowid: Int,

        @ColumnInfo(name = "server_id")
        @SerializedName("id")
        var serverId: String,

        @ColumnInfo(name = "_id")
        var idS: String,

        @ColumnInfo(name = "scheduled_date")
        @SerializedName("scheduled_audit_date")
        var date: Long,


        @ColumnInfo(name = "has_audit")
        var visited: Boolean = false,

        @ColumnInfo(name = "supplier_id")
        var supplierId: Int,

        @ColumnInfo(name = "criteria_id")
        @SerializedName("criteria_id")
        var criteriaId: Int = Integer.MIN_VALUE,

        @ColumnInfo(name = "form_audit_id")
        @SerializedName("audit_id")
        var fromAudit: Int
) {

    @ColumnInfo(name = "sync_status")
    var syncStatus: Int = 0
        set(value) {
            field = Database.TRUE
        }

}

