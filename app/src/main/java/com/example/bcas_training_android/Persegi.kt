package com.example.bcas_training_android

class Persegi : BangunDatar("persegi") {
    var sisi:Int = 0

    override fun hitung(): Int {
        return sisi * sisi
    }
}