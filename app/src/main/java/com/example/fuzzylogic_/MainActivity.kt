package com.example.fuzzylogic_

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Temperature setters
        val btnTemperatureHot : Button = findViewById(R.id.btnTemperatureHot)
        btnTemperatureHot.setOnClickListener {
            FuzzyLogic.setTemperature(Temperature.Hot)

        }
        val btnTemperatureNotSoHot : Button = findViewById(R.id.btnTemperatureNotSoHot)
        btnTemperatureNotSoHot.setOnClickListener {
            FuzzyLogic.setTemperature(Temperature.NotSoHot)

        }
        val btnTemperatureWarm : Button = findViewById(R.id.btnTemperatureWarm)
        btnTemperatureWarm.setOnClickListener {
            FuzzyLogic.setTemperature(Temperature.Warm)

        }
        val btnTemperatureNotSoCold : Button = findViewById(R.id.btnTemperatureNotSoCold)
        btnTemperatureNotSoCold.setOnClickListener {
            FuzzyLogic.setTemperature(Temperature.NotSoCold)

        }
        val btnTemperatureCold : Button = findViewById(R.id.btnTemperatureCold)
        btnTemperatureCold.setOnClickListener {
            FuzzyLogic.setTemperature(Temperature.Cold)

        }

        //Pressure setters
        val btnPressureHigh : Button = findViewById(R.id.btnPressureHigh)
        btnPressureHigh.setOnClickListener {
            FuzzyLogic.setPressure(Pressure.High)
        }
        val btnPressureMedium : Button = findViewById(R.id.btnPressureMedium)
        btnPressureMedium.setOnClickListener {
            FuzzyLogic.setPressure(Pressure.Medium)
        }
        val btnPressureLow : Button = findViewById(R.id.btnPressureLow)
        btnPressureLow.setOnClickListener {
            FuzzyLogic.setPressure(Pressure.Low)
        }

        //Submit
        val btnSubmit : Button = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            val results : CraneAngles = FuzzyLogic.decider()
            findViewById<TextView>(R.id.tvHotWaterAngle).text = results.hotAngle.toString()
            findViewById<TextView>(R.id.tvColdWaterAngle).text = results.coldAngle.toString()

        }


    }
}