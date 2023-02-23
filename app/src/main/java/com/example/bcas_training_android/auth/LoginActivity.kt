package com.example.bcas_training_android.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bcas_training_android.ProfileActivity
import com.example.bcas_training_android.databinding.ActivityLoginBinding
import java.text.StringCharacterIterator

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

//    private val email = "bry@gmail.com"
//    private val name = "bry conner"
//    private val address = "Jl. Sudiorjo Jakarta Pusat, Kecamatan Bandung"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra("email",email)
            intent.putExtra("password",password)
            startActivity(intent)
//            if (email == "" && password == "") {
//                Toast.makeText(this, "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
//            } else {
//            intentToScreenWithInput(ProfileActivity::class.java, email, password)
//            }
        }
    }

    private fun intentTo(screen: Class<*>) {
        val intent = Intent(applicationContext, screen)
//        intent.putExtra(KEY_NAME, name)
//        intent.putExtra(KEY_ADDRESS, address)
        startActivity(intent)
    }

    private fun intentToScreenWithInput(screen: Class<*>, input: String, input2: String) {
        val intent = Intent(applicationContext, screen)
        intent.putExtra(KEY_INPUT, input)
        intent.putExtra(KEY_PASSWORD, input2)
        startActivity(intent)
    }

    companion object {
        const val KEY_NAME = "name"
        const val KEY_PASSWORD = "password"
        const val KEY_INPUT = "input"
    }
}