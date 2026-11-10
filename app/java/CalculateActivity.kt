package com.example.spendingtrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val tvResults = findViewById<TextView>(R.id.tvCalculationResults)
        val btnBack = findViewById<Button>(R.id.btnBackCalc)

        val calcBuilder = StringBuilder()
        var totalWeeklyRemaining = 0.0

        try {
            // Loop through arrays to calculate remaining budget per day
            for (i in SpendingData.dates.indices) {
                val remaining = SpendingData.dailyBudgets[i] - SpendingData.dailySpent[i]
                totalWeeklyRemaining += remaining

                calcBuilder.append("Date: ${SpendingData.dates[i]}\n")
                calcBuilder.append("Remaining: R$remaining")
                if (remaining < 0) {
                    calcBuilder.append(" (Overspent!)\n")
                } else {
                    calcBuilder.append(" (Saved)\n")
                }
                calcBuilder.append("-----------------------------------\n\n")
            }

            calcBuilder.append("Total Weekly Remaining Balance: R$totalWeeklyRemaining\n")
        } catch (e: Exception) {
            calcBuilder.append("An error occurred during calculation: ${e.localizedMessage}")
        }

        tvResults.text = calcBuilder.toString()

        btnBack.setOnClickListener {
            finish()
        }
    }
}
