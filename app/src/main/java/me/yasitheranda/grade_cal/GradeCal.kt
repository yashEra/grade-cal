package me.yasitheranda.grade_cal

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GradeCal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grade_cal)

        val marksEditText: EditText = findViewById(R.id.gradecalculator)
        val calculateButton: Button = findViewById(R.id.calculateg)
        val resultTextView: TextView = findViewById(R.id.gradeView)

        calculateButton.setOnClickListener {
            val marksText = marksEditText.text.toString()
            if (marksText.isNotEmpty()) {
                val marks = marksText.toInt()
                if (marks in 0..100) { // Check if marks are within the range 0 to 100
                    val grade = calculateGrade(marks)
                    resultTextView.text = "Grade: $grade"
                } else {
                    resultTextView.text = "Marks should be between 0 and 100"
                    resultTextView.setTextColor(Color.RED)
                }
            } else {
                resultTextView.text = "Please enter marks"
                resultTextView.setTextColor(Color.RED)
            }
        }


        val homeButton: Button = findViewById(R.id.home)

        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun setTextColor(red: Int) {

    }

    private fun calculateGrade(marks: Int): String {
        return when {
            marks >= 90 -> "A+"
            marks >= 75 -> "A"
            marks >= 65 -> "B"
            marks >= 55 -> "C"
            marks >= 35 -> "S"
            else -> "F"
        }

    }
}