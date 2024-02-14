package me.yasitheranda.grade_cal

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AvgCal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avg_cal)

        val numbersEditText: EditText = findViewById(R.id.numbersEditText)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val numbersText = numbersEditText.text.toString().trim()
            if (numbersText.isNotEmpty()) {
                val numbers = numbersText.split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }
                if (numbers.isNotEmpty()) {
                    val average = numbers.average()
                    resultTextView.text = "Average: $average"
                    resultTextView.setTextColor(Color.parseColor("#0048E1"))
                    resultTextView.textSize = 50f
                } else {
                    resultTextView.text = "Please enter valid numbers separated by spaces"
                    resultTextView.setTextColor(Color.RED)
                    resultTextView.textSize = 32f
                }
            } else {
                resultTextView.text = "Please enter numbers"
                resultTextView.setTextColor(Color.RED)
                resultTextView.textSize = 50f
            }
        }

        val homeButton: Button = findViewById(R.id.homeButton)

        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}
