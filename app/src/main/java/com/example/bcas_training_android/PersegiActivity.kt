package com.example.bcas_training_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcas_training_android.databinding.ActivityHomeBinding
import com.example.bcas_training_android.databinding.ActivityPersegiBinding

class PersegiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersegiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersegiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            val sisi = binding.etSisi.text.toString().toIntOrNull()
            val persegi = Persegi()
            persegi.sisi = sisi ?: 0

            val result = persegi.hitung()
            binding.tvResult.text = result.toString()
        }
    }
}