package com.example.bcas_training_android.formula.abstraction

/*
* @param name: ini untuk nama
* */
abstract class BangunDatar(val name: String) {

    /**
     * ini adalah fungsi untuk menghitung
     * **/
    abstract fun hitung(onHitung: (keterangan: String) -> Unit): Int
}