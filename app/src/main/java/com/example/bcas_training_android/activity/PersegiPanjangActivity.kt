package com.example.bcas_training_android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.formula.PersegiPanjang
import com.example.bcas_training_android.databinding.ActivityPersegiPanjangBinding
import com.example.bcas_training_android.utils.toIntOrNol

class PersegiPanjangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersegiPanjangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersegiPanjangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            val panjang = binding.etPanjang.text.toString().toIntOrNol()
            val lebar = binding.etLebar.text.toString().toIntOrNol()

            val persegiPanjang = PersegiPanjang()
            persegiPanjang.panjang = panjang
            persegiPanjang.lebar = lebar

            val result = persegiPanjang.hitung {
                println(it)
            }
            binding.tvResult.text = result.toString()
        }
    }
}