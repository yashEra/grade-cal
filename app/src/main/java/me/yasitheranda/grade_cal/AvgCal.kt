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
    private val marks = mutableListOf<Int>() // List to store entered marks
    private lateinit var addedMarksTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avg_cal)

        val markEditText: EditText = findViewById(R.id.markEditText)
        val addMarkButton: Button = findViewById(R.id.addMarkButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        addedMarksTextView = findViewById(R.id.addedMarksTextView)

        addMarkButton.setOnClickListener {
            val markText = markEditText.text.toString().trim()
            if (markText.isNotEmpty()) {
                val mark = markText.toInt()
                marks.add(mark)
                updateAddedMarksText()
                markEditText.text.clear()
            } else {
                markEditText.error = "Please enter a mark"
            }
        }

        resetButton.setOnClickListener {
            marks.clear()
            updateAddedMarksText()
        }

        calculateButton.setOnClickListener {
            if (marks.isNotEmpty()) {
                val average = marks.average()
                resultTextView.text = "Average: $average"
                resultTextView.setTextColor(Color.parseColor("#0048E1"))
                resultTextView.textSize = 50f
            } else {
                resultTextView.text = "Please enter at least one mark"
                resultTextView.setTextColor(Color.RED)
                resultTextView.textSize = 32f
            }
        }

        val homeButton: Button = findViewById(R.id.homeButton)

        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateAddedMarksText() {
        addedMarksTextView.text = "Added Marks: ${marks.joinToString(", ")}"
    }
}
