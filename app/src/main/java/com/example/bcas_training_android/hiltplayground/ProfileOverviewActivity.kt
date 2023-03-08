package com.example.bcas_training_android.hiltplayground

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcas_training_android.base.PreferencesHelper
import com.example.bcas_training_android.databinding.ActivityInputProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileOverviewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInputProfileBinding

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            var namaValue = binding.etInputName.text
            var alamatValue = binding.etInputAddress.text

            if (namaValue.isNullOrEmpty().not() && alamatValue.isNullOrEmpty().not()) {
                preferencesHelper.saveName(namaValue.toString())
                preferencesHelper.saveAddress(alamatValue.toString())
                navigateBack()
            } else {
                Toast.makeText(this, "Isi data dulu lah !!", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun navigateBack() {
        startActivity(Intent(this, HiltPlaygroundActivity::class.java))
    }
}