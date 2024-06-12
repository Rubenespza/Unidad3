package com.example.practica
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View) {
        if (view is Button) {
            val number: String = view.text.toString()
            val currentText: String = resultTextView.text.toString()
            resultTextView.text = currentText + number
        }
    }
    fun operationClick(view: View) {
        if (view is Button) {
            operand1 = resultTextView.text.toString().toDouble()
            operation = view.text.toString()
            resultTextView.text = ""
        }
    }

    fun equalsClick(view: View) {
        operand2 = resultTextView.text.toString().toDouble()
        var result: Double = 0.0

        when (operation) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> {
                if (operand2 != 0.0) {
                    result = operand1 / operand2
                } else {
                    resultTextView.text = "Error"
                    return
                }
            }
        }

        resultTextView.text = result.toString()
    }
    fun clearClick(view: View) {
        resultTextView.text = ""
        operand1 = 0.0
        operand2 = 0.0
        operation=""
    }
}