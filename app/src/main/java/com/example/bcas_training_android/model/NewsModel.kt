package com.example.bcas_training_android.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel (
    val image: Int,
    val title: String,
    val descNews: String
) : Parcelable