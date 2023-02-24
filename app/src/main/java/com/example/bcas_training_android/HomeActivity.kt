package com.example.bcas_training_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.auth.LoginActivity
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_EMAIL
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_PASSWORD
import com.example.bcas_training_android.calculator.CalculatorActivity
import com.example.bcas_training_android.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle :Bundle? = intent.extras
        val email = bundle?.getString(KEY_EMAIL)
        val password = bundle?.getString(KEY_PASSWORD)

        binding.btnToCalculator.setOnClickListener {
            intentTo(CalculatorActivity::class.java)
        }

        binding.btnToProfile.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra(KEY_EMAIL, email)
            intent.putExtra(KEY_PASSWORD, password)
            startActivity(intent)

        }

    }

    private fun intentTo(classs: Class<*>){
        val intent = Intent(this, classs)
        startActivity(intent)
    }



}