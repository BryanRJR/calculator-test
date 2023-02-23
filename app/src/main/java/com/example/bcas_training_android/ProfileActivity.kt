package com.example.bcas_training_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_INPUT
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_NAME
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_PASSWORD
import com.example.bcas_training_android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle :Bundle ?=intent.extras
        var email = bundle!!.getString("email")
        var password = bundle!!.getString("password")

        binding.tvName.text = email
        binding.tvAddress.text = password
    }
}