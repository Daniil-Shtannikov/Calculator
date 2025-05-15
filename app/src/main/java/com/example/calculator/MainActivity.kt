package com.example.calculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity(), View.OnClickListener {

    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button

    private lateinit var tvResult: TextView

    var oper: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Исправлен импорт R

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)

        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        if (TextUtils.isEmpty(etNum1.text.toString()) || TextUtils.isEmpty(etNum2.text.toString())) { return }

        num1 = etNum1.text.toString().toFloat()
        num2 = etNum2.text.toString().toFloat()

        when (v.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
            }
        }

        tvResult.text = "$num1 $oper $num2 = $result"
    }
}