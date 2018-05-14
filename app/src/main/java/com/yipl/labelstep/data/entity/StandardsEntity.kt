package com.yipl.labelstep.data.entity

import android.os.Parcel
import android.os.Parcelable
import java.util.*

public class StandardsEntity : Parcelable {
    public var success: Boolean = false
    public var data: List<StandardsDataEntity>


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByte(if (this.success) 1.toByte() else 0.toByte())
        dest.writeList(this.data)
    }


    protected constructor(`in`: Parcel) {
        this.success = `in`.readByte().toInt() != 0
        this.data = ArrayList<StandardsDataEntity>()
        `in`.readList(this.data, StandardsDataEntity::class.java!!.getClassLoader())
    }

    companion object {

        val CREATOR: Parcelable.Creator<StandardsEntity> = object : Parcelable.Creator<StandardsEntity> {
            override fun createFromParcel(source: Parcel): StandardsEntity {
                return StandardsEntity(source)
            }

            override fun newArray(size: Int): Array<StandardsEntity?> {
                return arrayOfNulls(size)
            }
        }
    }
}