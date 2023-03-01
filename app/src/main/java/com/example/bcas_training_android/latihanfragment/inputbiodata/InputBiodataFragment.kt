package com.example.bcas_training_android.latihanfragment.inputbiodata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bcas_training_android.R
import com.example.bcas_training_android.databinding.ActivityHostBinding
import com.example.bcas_training_android.databinding.InputBiodataFragmentBinding

class InputBiodataFragment: Fragment() {
    private lateinit var binding: InputBiodataFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InputBiodataFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            handleSubmitButton()
        }
    }

    private fun handleSubmitButton() {
        val checkEtName = binding.etName.text.isNullOrEmpty().not()
        val checkEtAddress = binding.etAddress.text.isNullOrEmpty().not()
        val checkEtNumber = binding.etNumber.text.isNullOrEmpty().not()
        val checkEtEmail = binding.etEmail.text.isNullOrEmpty().not()

        if (checkEtName && checkEtAddress && checkEtNumber && checkEtEmail) {
            var bundle = Bundle().apply {
                putString(NAME_KEY, binding.etName.text.toString())
            }
            val successFragment = SuccessBiodataFragment().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, successFragment)
                .commit()
        } else {
            Toast.makeText(context, "tolong lengkapi biodata", Toast.LENGTH_SHORT).show()
        }


    }

    companion object {
        const val NAME_KEY = "name"
    }
}

