package com.example.bcas_training_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.auth.LoginActivity
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_EMAIL
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

        val bundle :Bundle? = intent.extras
        val email = bundle?.getString(KEY_EMAIL)
        val password = bundle?.getString(KEY_PASSWORD)

        binding.tvName.text = email
        binding.tvAddress.text = password

        binding.btnLogout.setOnClickListener {
            intentTo(LoginActivity::class.java)
        }
    }

    private fun intentTo(screen: Class<*>) {
        val intent = Intent(this, screen)
        startActivity(intent)
    }

    companion object {
        private const val dataNews = "dataNews"
        fun navigateToActivityDetail() = Intent().apply {

        }
    }
}