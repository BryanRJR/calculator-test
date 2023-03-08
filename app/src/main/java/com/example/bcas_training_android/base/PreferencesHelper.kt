package com.example.bcas_training_android.base

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveName(value: String) {
        sharedPreferences.edit().putString(KEY_NAME, value).apply()
    }

    fun getName(): String? {
        return sharedPreferences.getString(KEY_NAME, "-")
    }

    fun saveAddress(value: String) {
        sharedPreferences.edit().putString(KEY_ADDRESS, value).apply()
    }

    fun getAddress(): String? {
        return sharedPreferences.getString(KEY_ADDRESS, "-")
    }

    fun clearDataPref() {
        sharedPreferences.edit().clear().commit()
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"
    }
}