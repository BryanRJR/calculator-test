package com.example.bcas_training_android.formula

import com.example.bcas_training_android.formula.abstraction.BangunDatar

class Segitiga: BangunDatar(NAME) {
    var alas: Int = 0
    var tinggi: Int = 0

    override fun hitung(onHitung: (keterangan: String) -> Unit): Int {
        val result = 0.5 * alas * tinggi
        onHitung.invoke("Hitung segitiga")
        return result.toInt()
    }

    companion object {
        private const val NAME = "segitiga"
    }
}