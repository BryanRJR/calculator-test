package com.example.bcas_training_android.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.HomeActivity
import com.example.bcas_training_android.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private var input1 = 0
    private var input2 = 0
    private var inputResult = 0
    private var operatorType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambah.setOnClickListener {
            changeOperator("+")
            operatorType = OperatorType.TAMBAH
        }
        binding.btnKurang.setOnClickListener {
            changeOperator("-")
            operatorType = OperatorType.KURANG
        }
        binding.btnKali.setOnClickListener {
            changeOperator("x")
            operatorType = OperatorType.KALI
        }
        binding.btnBagi.setOnClickListener {
            changeOperator(":")
            operatorType = OperatorType.BAGI
        }
        binding.btnResult.setOnClickListener {
            calculate()
        }

        binding.btnBack.setOnClickListener {
            val backToMain = Intent(this, HomeActivity::class.java)
            startActivity(backToMain)
            finish()
        }
    }

    private fun calculate() {
        input1 = binding.etInput1.text.toString().toInt()
        input2 = binding.etInput2
            .text
            .toString()
            .toInt()

        when (operatorType) {
            OperatorType.TAMBAH -> {
                // penambahan
                tambah()
            }
            OperatorType.KURANG -> {
                // pengurangan
                kurang()
            }
            OperatorType.KALI -> {
                // perkalian
                kali()
            }
            OperatorType.BAGI -> {
                // pembagian
                bagi()
            }
        }
        binding.tvResult.text = inputResult.toString()
    }

    private fun changeOperator(operator: String) {
        binding.tvOperator.text = operator
    }

    private fun tambah() {
        inputResult = input1 + input2
    }

    private fun kurang() {
        inputResult = input1 - input2
    }

    private fun kali() {
        inputResult = input1 * input2
    }

    private fun bagi() {
        inputResult = input1 / input2
    }

}