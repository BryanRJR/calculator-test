package com.example.bcas_training_android.formula

import com.example.bcas_training_android.formula.abstraction.BangunDatar

class PersegiPanjang : BangunDatar(NAME) {
    var panjang:Int = 0
    var lebar:Int = 0

    override fun hitung(onHitung: (keterangan: String) -> Unit): Int {
        val result = panjang * lebar
        onHitung.invoke("Hitung persegi panjang")
        return result
    }

    companion object {
        private const val NAME = "persegi_panjang"
    }
}