package com.example.spendingtrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnView = findViewById<Button>(R.id.btnViewSpending)
        val btnCalc = findViewById<Button>(R.id.btnCalculateBudget)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnView.setOnClickListener {
            startActivity(Intent(this, ViewActivity::class.java))
        }

        btnCalc.setOnClickListener {
            startActivity(Intent(this, CalculateActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity() // Closes all activities and exits app safely
        }
    }
}
