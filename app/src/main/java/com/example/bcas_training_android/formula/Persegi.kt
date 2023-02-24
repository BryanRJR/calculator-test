package com.example.bcas_training_android.formula

import com.example.bcas_training_android.formula.abstraction.BangunDatar

class Persegi : BangunDatar(NAME) {
    var sisi:Int = 0

    override fun hitung(onHitung: (keterangan: String) -> Unit): Int {
        val result = sisi * sisi
        onHitung.invoke("Hitung persegi")
        return result
    }

    companion object {
        private const val NAME = "persegi"
    }

}