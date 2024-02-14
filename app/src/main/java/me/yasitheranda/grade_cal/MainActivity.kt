package me.yasitheranda.grade_cal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradeCalButton: Button = findViewById(R.id.gradecal)

        // For navigate grade_cal.xml
        gradeCalButton.setOnClickListener {
            val intent = Intent(this, GradeCal::class.java)
            startActivity(intent)
        }

        val avgCalButton: Button = findViewById(R.id.avgcal)

        // For navigate grade_cal.xml
        avgCalButton.setOnClickListener {
            val intent = Intent(this, AvgCal::class.java)
            startActivity(intent)
        }

        val exitButton: Button = findViewById(R.id.exit)

        // For close the current activity, effectively exiting the app
        exitButton.setOnClickListener {
            finish()
        }

    }
}