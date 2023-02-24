package com.example.bcas_training_android.utils

fun String.toIntOrNol(): Int {
    val number = this.toIntOrNull()
    return number ?: 0
}