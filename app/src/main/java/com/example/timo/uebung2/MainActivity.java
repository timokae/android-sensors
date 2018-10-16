package com.example.timo.uebung2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;

    TextView textViewAccelerometer;
    TextView textViewProximity;
    TextView textViewLight;
    TextView textViewMagneticField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAccelerometer = findViewById(R.id.textViewAccelerometer);
        textViewProximity = findViewById(R.id.textViewProximity);
        textViewLight = findViewById(R.id.textViewLight);
        textViewMagneticField = findViewById(R.id.textViewMagneticField);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                switch (event.sensor.getType()) {
                    case Sensor.TYPE_ACCELEROMETER:
                        textViewAccelerometer.setText("X: " + event.values[0] + "\n" + "Y: " + event.values[1] + "\n" + "Z: " + event.values[2]);
                        break;
                    case Sensor.TYPE_PROXIMITY:
                        textViewProximity.setText("X: " + event.values[0] + " cm" + " [" + event.values[1] + "]");
                        break;
                    case Sensor.TYPE_LIGHT:
                        textViewLight.setText(event.values[0] + " lx");
                        break;
                    case Sensor.TYPE_MAGNETIC_FIELD:
                        textViewMagneticField.setText("X: " + event.values[0] + "\n" + "Y: " + event.values[1] + "\n" + "Z: " + event.values[2]);
                        break;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), sensorManager.SENSOR_DELAY_NORMAL);
    }


}
