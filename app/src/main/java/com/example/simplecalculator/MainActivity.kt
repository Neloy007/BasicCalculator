package com.example.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            calculate("+")
        }

        binding.subBtn.setOnClickListener {
            calculate("-")
        }
        binding.mulBtn.setOnClickListener {
            calculate("x")
        }
        binding.divBtn.setOnClickListener {
            calculate("÷")
        }

        binding.modBtn.setOnClickListener {
            calculate("%")
        }

        binding.resetBtn.setOnClickListener {
            binding.firstEt.text.clear()
            binding.secondEt.text.clear()
            binding.resultTv.text ="Result: "
        }



    }

    private fun calculate(Operation:String){
        var num1Str = binding.firstEt.text.toString()
        var num2Str = binding.secondEt.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()){
            Toast.makeText(this,"Enter Both Numbers",Toast.LENGTH_LONG).show()
            return
        }

        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        var result = 0.0

        result = when(Operation){
            "+"-> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "÷" -> if(num2 ==0.0 || num1 == 0.0){
                Toast.makeText(this,"Connot Devide By Zero", Toast.LENGTH_LONG).show()
                return
            }else{
              num1/num2
            }
            "%" -> if(num2 ==0.0){
                Toast.makeText(this,"Connot Modulus", Toast.LENGTH_LONG).show()
                return
            }else{
                num1 % num2
            }
            else -> 0.0
        }
        binding.resultTv.text = "Result: %.2f".format(result)
    }
}