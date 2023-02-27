package com.example.bcas_training_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.databinding.ActivityBiodataBinding
import com.example.bcas_training_android.home.HomeActivity

class BiodataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBiodataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = "Bryan Rantung"
        binding.tvName.text = name

        var age = 24
        binding.tvAge.text = age.toString()

        var status = "Single"
        binding.tvStatus.text = status

        var address = "Lebak Bulus"
        binding.tvAddress.text = address

        var number = "0899922233"
        binding.tvNumber.text = number

        var email = "bryan98@gmail.com"
        binding.tvEmail.text = email

        binding.btnBack.setOnClickListener {
            val backToMain = Intent(this, HomeActivity::class.java)
            startActivity(backToMain)
            finish()
        }
    }
}