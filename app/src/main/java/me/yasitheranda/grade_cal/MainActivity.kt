package me.yasitheranda.grade_cal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitButton: Button = findViewById(R.id.exit)

        // For close the current activity, effectively exiting the app
        exitButton.setOnClickListener {
            finish()
        }

    }
}