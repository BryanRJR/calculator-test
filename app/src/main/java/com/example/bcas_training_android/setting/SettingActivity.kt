package com.example.bcas_training_android.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcas_training_android.databinding.ActivityListBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    private val settings = listOf(
        "Profile", "Wallet", "Password", "Email", "Username", "Image Profile", "Full Name", "Logout"
    )

    private val settingAdapter = SettingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSimple.layoutManager = LinearLayoutManager(this)
        binding.rvSimple.adapter = settingAdapter

        // AppBar
        binding.include.tvAppbar.text = "Setting"
        binding.include.ivArrow.setOnClickListener {
            onBackPressed()
        }

        settingAdapter.addItems(settings)
    }
}