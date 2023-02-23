package com.example.bcas_training_android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.databinding.ActivityPersegiPanjangBinding

class PersegiPanjangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersegiPanjangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersegiPanjangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            val panjang = binding.etPanjang.text.toString().toIntOrNull()
            val lebar = binding.etLebar.text.toString().toIntOrNull()

            val persegiPanjang = PersegiPanjang()
            persegiPanjang.panjang = panjang ?: 0
            persegiPanjang.lebar = lebar ?: 0

            val result = persegiPanjang.hitung()
            binding.tvResult.text = result.toString()
        }
    }
}