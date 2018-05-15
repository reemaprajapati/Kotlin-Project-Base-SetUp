package com.yipl.labelstep.data.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yipl.labelstep.data.LatLng
import com.yipl.labelstep.data.entity.ContactPerson
import com.yipl.labelstep.data.entity.Location


class DataTypeConverter {

    @TypeConverter
    fun stringToContactPerson(json: String): List<ContactPerson> {
        val gson = Gson()
        val type = object : TypeToken<List<ContactPerson>>() {

        }.getType()
        val measurements = gson.fromJson<List<ContactPerson>>(json, type)
        return measurements
    }

    @TypeConverter
    fun contactPersonToString(list: List<ContactPerson>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ContactPerson>>() {
        }.getType()
        val json = gson.toJson(list, type)
        return json
    }


    @TypeConverter
    fun stringToList(value: String): ArrayList<String> {
        val listType = object : TypeToken<ArrayList<String>>() {
        }.type
        return Gson().fromJson<ArrayList<String>>(value, listType)
    }

    @TypeConverter
    fun listToString(list: ArrayList<String>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<String>>() {
        }.getType()
        val json = gson.toJson(list, type)
        return json
    }


    @TypeConverter
    fun StringtoLocation(string: String): Location {
        val locationType = object : TypeToken<Location>() {
        }.type
        return Gson().fromJson(string, locationType)
    }

    @TypeConverter
    fun locationToString(value: Location): String {
        if (value.latitude.isEmpty() && value.longitude.isEmpty())
            return LatLng.DEFAULT_LAT + "," + LatLng.DEFAULT_LNG
        return value.latitude + "," + value.longitude
    }
}



