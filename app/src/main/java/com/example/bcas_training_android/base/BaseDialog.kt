package com.example.bcas_training_android.base

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.example.bcas_training_android.R
import com.example.bcas_training_android.databinding.BaseDialogBinding
import com.example.bcas_training_android.home.HomeActivity
import com.example.bcas_training_android.home.HomeMainAdapter

class BaseDialog(context: Context,
                 private var title: String,
                 private var subTitle: String,
                 private val onOkClicked: (() -> Unit),
                 private val withImage:Boolean,
                 private var image: Int? = null,
                 ): Dialog(context) {
    private lateinit var binding: BaseDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BaseDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivDialog.isVisible = withImage
        binding.ivDialog.setImageResource(image ?: R.drawable.ic_android)

        binding.tvWarning.text = title
        binding.tvDescDialog.text = subTitle

        binding.btnProcess.setOnClickListener {
            onOkClicked.invoke()
        }

        binding.btnCancelDialog.setOnClickListener {
            dismissDialog()
        }

    }

    private fun dismissDialog(){
        dismiss()
    }

}