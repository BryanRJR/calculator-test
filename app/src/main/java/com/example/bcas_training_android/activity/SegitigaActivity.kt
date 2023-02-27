package com.example.bcas_training_android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bcas_training_android.databinding.ActivityHomeBinding
import com.example.bcas_training_android.databinding.ActivitySegitigaBinding
import com.example.bcas_training_android.formula.Persegi
import com.example.bcas_training_android.formula.Segitiga
import com.example.bcas_training_android.utils.toIntOrNol
import com.google.android.material.snackbar.Snackbar

class SegitigaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegitigaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegitigaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            if (binding.etAlas.text.toString().isEmpty() || binding.etTinggi.text.toString()
                    .isEmpty()
            ) {
                Snackbar.make(binding.root, "Field Tidak Boleh Kosong", Snackbar.LENGTH_SHORT).show()
            } else {
                val alas = binding.etAlas.text.toString().toIntOrNol()
                val tinggi = binding.etTinggi.text.toString().toIntOrNol()
                val segitiga = Segitiga()
                segitiga.alas = alas
                segitiga.tinggi = tinggi

                val result = segitiga.hitung { keterangan ->
                    println(keterangan)
                }
                binding.tvResult.text = result.toString()
            }
        }
    }
}