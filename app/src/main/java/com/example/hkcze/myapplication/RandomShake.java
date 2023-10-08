package com.example.hkcze.myapplication;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class RandomShake extends AppCompatActivity {

    private SensorManager sm;
    private float acelVal;
    private float acelLast;
    private float shake;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_shake);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
    }


    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            Class Activity = null;

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 3) {
                Random rand = new Random();
                int j = rand.nextInt(30);
                switch (j) {
                    case 1:
                        Activity = HouseFood1.class;
                        break;
                    case 2:
                        Activity = HouseFood2.class;
                        break;
                    case 3:
                        Activity = HouseFood3.class;
                        break;
                    case 4:
                        Activity = HouseFood4.class;
                        break;
                    case 5:
                        Activity = JapaneseFood1.class;
                        break;
                    case 6:
                        Activity = JapaneseFood2.class;
                        break;
                    case 7:
                        Activity = JapaneseFood3.class;
                        break;
                    case 8:
                        Activity = JapaneseFood4.class;
                        break;
                    case 9:
                        Activity = KoreaFood1.class;
                        break;
                    case 10:
                        break;
                    case 11:
                        Activity = KoreaFood2.class;
                        break;
                    case 12:
                        Activity = KoreaFood3.class;
                        break;
                    case 13:
                        Activity = JunkFood1.class;
                        break;
                    case 14:
                        Activity = JunkFood2.class;
                        break;
                    case 15:
                        Activity = JunkFood3.class;
                        break;
                    case 16:
                        Activity = SpicyFood1.class;
                        break;
                    case 17:
                        Activity = SpicyFood2.class;
                        break;
                    case 18:
                        Activity = SpicyFood3.class;
                        break;
                    case 19:
                        Activity = HealthFood1.class;
                        break;
                    case 20:
                        Activity = HouseFood2.class;
                        break;
                    case 21:
                        Activity = HealthFood3.class;
                        break;
                    case 22:
                        Activity = FitFood1.class;
                        break;
                    case 23:
                        Activity = FitFood2.class;
                        break;
                    case 24:
                        Activity = FitFood3.class;
                        break;
                    case 25:
                        Activity = Dessert1.class;
                        break;
                    case 26:
                        Activity = Dessert2.class;
                        break;
                    case 27:
                        Activity = Dessert3.class;
                        break;
                    case 28:
                        Activity = Drink1.class;
                        break;
                    case 29:
                        Activity = Drink2.class;
                        break;
                    case 30:
                        Activity = Drink3.class;
                        break;
                }
                Intent intent = new Intent(getBaseContext(),Activity);
                startActivity(intent);
                sm.unregisterListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

    };
}