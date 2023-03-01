package com.example.bcas_training_android.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.R
import com.example.bcas_training_android.databinding.ActivityHostBinding
import com.example.bcas_training_android.latihanfragment.inputbiodata.InputBiodataFragment

class HostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBiodataFragment()
    }

    private fun initBiodataFragment() {
        val inputBiodataFragment = InputBiodataFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, inputBiodataFragment).commit()
    }
}