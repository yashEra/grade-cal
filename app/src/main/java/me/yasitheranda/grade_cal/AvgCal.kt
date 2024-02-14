package me.yasitheranda.grade_cal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.round

class AvgCal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avg_cal)

        val marksContainer: LinearLayout = findViewById(R.id.marksContainer)
        val calculateButton: Button = findViewById(R.id.averageButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val marks = mutableListOf<Int>()
            for (i in 0 until marksContainer.childCount) {
                val editText = marksContainer.getChildAt(i) as EditText
                val markText = editText.text.toString().trim()
                if (markText.isNotEmpty()) {
                    val mark = markText.toIntOrNull()
                    if (mark != null) {
                        marks.add(mark)
                    } else {
                        resultTextView.text = "Please enter valid numbers for all marks"
                        return@setOnClickListener
                    }
                } else {
                    resultTextView.text = "Please enter numbers for all marks"
                    return@setOnClickListener
                }
            }

            if (marks.isNotEmpty()) {
                val average = calculateAverage(marks)
                resultTextView.text = "Average: ${round(average * 100) / 100}"
            } else {
                resultTextView.text = "Please enter numbers for all marks"
            }
        }

        val homeButton: Button = findViewById(R.id.homeButton)

        homeButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculateAverage(marks: List<Int>): Double {
        val sum = marks.sum()
        return sum.toDouble() / marks.size
    }
}
