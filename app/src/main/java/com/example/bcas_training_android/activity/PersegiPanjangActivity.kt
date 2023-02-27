package com.example.bcas_training_android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bcas_training_android.formula.PersegiPanjang
import com.example.bcas_training_android.databinding.ActivityPersegiPanjangBinding
import com.example.bcas_training_android.utils.toIntOrNol
import com.example.bcas_training_android.utils.toast

class PersegiPanjangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersegiPanjangBinding
    private val histories: MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersegiPanjangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            if (binding.etPanjang.text.toString().isEmpty() || binding.etLebar.text.toString().isEmpty())
            {
                toast("Field Tidak Boleh Kosong")
            } else {
            val panjang = binding.etPanjang.text.toString().toIntOrNol()
            val lebar = binding.etLebar.text.toString().toIntOrNol()

            val persegiPanjang = PersegiPanjang()
            persegiPanjang.panjang = panjang
            persegiPanjang.lebar = lebar

            val result = persegiPanjang.hitung {
                println(it)
            }
            histories.add(result)
//            histories.forEach {  }

            val textHistory: () -> String = {
                var text = ""
                for (item in histories){
                    text = text + "$item, "
                }
                text
            }
            binding.tvHistory.text = textHistory.invoke()

            binding.tvResult.text = result.toString()
            }
        }
    }
}