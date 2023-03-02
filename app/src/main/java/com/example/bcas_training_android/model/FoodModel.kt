package com.example.bcas_training_android.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodModel (
    val image: String?,
    val title: String,
    val descFood: String?,
    val category: String?
) : Parcelable