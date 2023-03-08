package com.example.bcas_training_android.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

interface SharedPreferenceModule {
    fun provideSharePreferences(context: Context): SharedPreferences
}