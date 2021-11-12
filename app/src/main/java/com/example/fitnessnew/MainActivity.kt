package com.example.fitnessnew

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener, Listener{

    private var sensorManager: SensorManager? = null
    private var stepDetector : StepDetect? = null
    private var steps : Int = 0



    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            stepDetector!!.updateAccelerometer(event.timestamp, event.values[0], event.values[1], event.values[2])
        }
    }

    override fun step(timeNs: Long) {
        steps++
        tv_stepstaken.text = steps.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      stepDetector = StepDetect()
        stepDetector!!.registerListener(this)

       var caloriemove = findViewById<Button>(R.id.calo_act2)
        caloriemove.setOnClickListener {
            val intent = Intent(this, CalorieCalculator::class.java)
            startActivity(intent);
        }


       btn_start.setOnClickListener(View.OnClickListener {
           steps = 0
            sensorManager!!.registerListener(this, sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_FASTEST)
        })

        btn_stop.setOnClickListener(View.OnClickListener {
            sensorManager!!.unregisterListener(this)

           sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager




        })


    }




}