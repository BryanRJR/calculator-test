package com.example.bcas_training_android.calculator

class Persegi : BangunDatar("persegi") {
    var sisi:Int = 0

    override fun hitung(): Int {
        return sisi * sisi
    }
}