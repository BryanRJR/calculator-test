package com.example.bcas_training_android

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bcas_training_android.auth.LoginActivity
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_EMAIL
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_INPUT
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_NAME
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_PASSWORD
import com.example.bcas_training_android.base.BaseDialog
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

        // AppBar
        binding.includeAppbar.tvAppbar.text = "Setting"
        binding.includeAppbar.ivArrow.setOnClickListener {
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            val dialog = BaseDialog(this, "Logout", "Anda Yakin Ingin Melakukan Tindakan Ini?", onOkClicked = {
                Toast.makeText(this, "Anda Berhasil Logout", Toast.LENGTH_LONG).show()
                finish()
            },
            withImage = true,
            image = R.drawable.jokowi
            )
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.show()
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