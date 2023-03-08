package com.example.bcas_training_android.hiltplayground

import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.R
import com.example.bcas_training_android.base.PreferencesHelper
import com.example.bcas_training_android.databinding.ActivityHiltPlaygroundBinding
import com.example.bcas_training_android.model.Engine
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltPlaygroundActivity : AppCompatActivity() {
    private var _binding: ActivityHiltPlaygroundBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHiltPlaygroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateValueLayout()

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, ProfileOverviewActivity::class.java)
            startActivity(intent)
        }

        binding.btnClearPref.setOnClickListener {
            preferencesHelper.clearDataPref()
            updateValueLayout()
        }

    }

    private fun updateValueLayout() {
        val getNameFromLocal = preferencesHelper.getName()
        val getAddressFromLocal = preferencesHelper.getAddress()

        binding.tvName.text = getNameFromLocal
        binding.tvAddress.text = getAddressFromLocal
    }
}