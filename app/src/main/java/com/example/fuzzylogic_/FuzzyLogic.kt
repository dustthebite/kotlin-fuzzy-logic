package com.example.fuzzylogic_

import com.example.fuzzylogic_.Pressure
import com.example.fuzzylogic_.Temperature

object FuzzyLogic {
    private val smallAngle : Int = 15
    private val mediumAngle : Int = 30
    private val bigAngle : Int = 45

    private var currentTemperature : Temperature = Temperature.Warm
    private var currentPressure: Pressure = Pressure.Medium

    val getTemperature : Temperature
        get() {
            return currentTemperature
        }

    val getPressure : Pressure
        get() {
            return currentPressure
        }

    fun setTemperature(tmp : Temperature)
    {
        currentTemperature = tmp
    }

    fun setPressure(prs: Pressure)
    {
        currentPressure = prs
    }


    //left is -
    //right is +
    fun decider() : CraneAngles
    {
        return when (currentTemperature) {
            Temperature.Hot -> {
                when(currentPressure) {
                    Pressure.High -> CraneAngles(-mediumAngle, mediumAngle)
                    Pressure.Medium -> CraneAngles(0, mediumAngle)
                    Pressure.Low -> CraneAngles(0,0)
                }
            }

            Temperature.NotSoHot -> {
                when(currentPressure){
                    Pressure.High -> CraneAngles(smallAngle, 0)
                    Pressure.Medium -> CraneAngles(0,0)
                    Pressure.Low -> CraneAngles(smallAngle,smallAngle)
                }
            }
            Temperature.Warm -> {
                when(currentPressure)
                {
                    Pressure.High -> CraneAngles(-smallAngle,-smallAngle)
                    Pressure.Medium -> CraneAngles(0,0)
                    Pressure.Low -> CraneAngles(smallAngle,smallAngle)
                }
            }
            Temperature.NotSoCold -> {
                when(currentPressure)
                {
                    Pressure.High -> CraneAngles(mediumAngle, -mediumAngle)
                    Pressure.Medium -> CraneAngles(mediumAngle, -smallAngle)
                    Pressure.Low -> CraneAngles(0,0)
                }
            }
            Temperature.Cold -> {
                when(currentPressure)
                {
                    Pressure.High -> CraneAngles(-mediumAngle, mediumAngle)
                    Pressure.Medium -> CraneAngles(0,0)
                    Pressure.Low -> CraneAngles(bigAngle, 0)
                }
            }
        }

    }
}