package com.example.bcas_training_android.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcas_training_android.formula.Persegi
import com.example.bcas_training_android.databinding.ActivityPersegiBinding
import com.example.bcas_training_android.utils.toIntOrNol
import com.example.bcas_training_android.utils.toast

class PersegiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersegiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersegiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            if (binding.etSisi.text.toString().isEmpty())
            {
                toast("Field Tidak Boleh Kosong")
            } else {
            val sisi = binding.etSisi.text.toString().toIntOrNol()
            val persegi = Persegi()
            persegi.sisi = sisi

            val result = persegi.hitung { keterangan ->
                println(keterangan)
            }
            binding.tvResult.text = result.toString()
            }
        }
    }
}