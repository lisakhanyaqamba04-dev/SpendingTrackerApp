package com.example.spendingtrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val tvDetails = findViewById<TextView>(R.id.tvSpendingDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val stringBuilder = StringBuilder()

        // Loop through parallel arrays to compile the records
        for (i in SpendingData.dates.indices) {
            stringBuilder.append("Date: ${SpendingData.dates[i]}\n")
            stringBuilder.append("Budget: R${SpendingData.dailyBudgets[i]}\n")
            stringBuilder.append("Spent: R${SpendingData.dailySpent[i]}\n")
            stringBuilder.append("Note: ${SpendingData.comments[i]}\n")
            stringBuilder.append("-----------------------------------\n\n")
        }

        tvDetails.text = stringBuilder.toString()

        btnBack.setOnClickListener {
            finish()
        }
    }
}
