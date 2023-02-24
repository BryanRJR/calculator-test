package com.example.bcas_training_android.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToPersegi.setOnClickListener {
            intentTo(PersegiActivity::class.java)
        }

        binding.btnToPersegiPanjang.setOnClickListener {
            intentTo(PersegiPanjangActivity::class.java)
        }

        binding.btnToSegitiga.setOnClickListener {
            intentTo(SegitigaActivity::class.java)
        }

    }

    private fun intentTo(classs: Class<*>){
        val intent = Intent(this, classs)
        startActivity(intent)
    }



}