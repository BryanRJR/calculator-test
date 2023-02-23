package com.example.bcas_training_android.calculator

class PersegiPanjang : BangunDatar("persegi_panjang") {
    var panjang:Int = 0
    var lebar:Int = 0

    override fun hitung(): Int {
        return panjang * lebar
    }
}