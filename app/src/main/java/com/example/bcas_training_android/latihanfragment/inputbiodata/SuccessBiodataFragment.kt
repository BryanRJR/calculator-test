package com.example.bcas_training_android.latihanfragment.inputbiodata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_NAME
import com.example.bcas_training_android.databinding.InputBiodataFragmentBinding
import com.example.bcas_training_android.databinding.SuccessRegisterFragmentBinding

class SuccessBiodataFragment: Fragment() {
    private lateinit var binding: SuccessRegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SuccessRegisterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDataFromArgument()
    }

    private fun setDataFromArgument() {
        var getNameFromArgument = arguments?.getString(KEY_NAME)
        binding.tvName.text = getNameFromArgument
    }
}