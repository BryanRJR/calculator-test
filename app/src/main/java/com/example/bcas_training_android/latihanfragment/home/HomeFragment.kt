package com.example.bcas_training_android.latihanfragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcas_training_android.R
import com.example.bcas_training_android.databinding.HomeFragmentBinding
import com.example.bcas_training_android.databinding.SuccessRegisterFragmentBinding
import com.example.bcas_training_android.latihanfragment.inputbiodata.InputBiodataFragment

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener {
            navigateToRegister()
        }
    }

    private fun navigateToRegister() {
        val registerFragment = InputBiodataFragment()
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, registerFragment)
            .addToBackStack(
                REGISTER_FRAGMENT_KEY
            )
            .commit()
    }

    companion object {
        const val REGISTER_FRAGMENT_KEY = "register"
    }
}