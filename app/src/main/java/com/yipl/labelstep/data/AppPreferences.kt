package com.yipl.labelstep.data

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferences @Inject constructor(context: Context) {
    var preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences(Preference.PREFERENCE_NAME, Context
                .MODE_PRIVATE)
    }

    var example: String
        get() = preferences.getString(Preference.EXAMPLE_DATA, "Error")
        set(data) = preferences.edit().putString(Preference.EXAMPLE_DATA, data).apply()

}