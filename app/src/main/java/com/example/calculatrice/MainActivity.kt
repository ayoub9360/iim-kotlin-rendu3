package com.example.calculatrice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity() {
    var isNewOperator = true
    var edt1: EditText? = null
    var operator = "+"
    var initialNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOperator) result.setText("")
        isNewOperator = false
        var number: String = result.text.toString()
        if (view.id === one.id) {
            number += "1"
        } else if (view.id === two.id) {
            number += "2"
        } else if (view.id === three.id) {
            number += "3"
        } else if (view.id === four.id) {
            number += "4"
        } else if (view.id === five.id) {
            number += "5"
        } else if (view.id === six.id) {
            number += "6"
        } else if (view.id === seven.id) {
            number += "7"
        } else if (view.id === eight.id) {
            number += "8"
        } else if (view.id === nine.id) {
            number += "9"
        } else if (view.id === dot.id) {
            number += "."
        }
        result.setText(number)
    }

    fun operatorEvent(view: View) {
        isNewOperator = true
        initialNumber = result.text.toString()
        if (view.id === multiply.id) {
            operator = "*"
        } else if (view.getId() === substract.id) {
            operator = "-"
        } else if (view.getId() === divide.id) {
            operator = "/"
        } else if (view.getId() === add.id) {
            operator = "+"
        }
    }

    fun equalEvent(view: View?) {
        val newNumber: String = result.text.toString()
        var output = 0.0
        if (operator === "+") output = initialNumber.toDouble() + newNumber.toDouble()
        if (operator === "/") output = initialNumber.toDouble() / newNumber.toDouble()
        if (operator === "*") output = initialNumber.toDouble() * newNumber.toDouble()
        if (operator === "-") output = initialNumber.toDouble() - newNumber.toDouble()
        result.setText(output.toString() + "")
    }

    fun clearEvent(view: View?) {
        result.setText("0")
        isNewOperator = true
    }

    fun percentEvent(view: View?) {
        val num: Double = result.text.toString().toDouble() / 100
        result.setText(num.toString() + "")
        isNewOperator = true
    }

}