package com.example.kjoseph.sensors.factory;

import android.support.v4.app.Fragment;

import com.example.kjoseph.sensors.ui.AccelerometerFragment;
import com.example.kjoseph.sensors.ui.GravityFragment;
import com.example.kjoseph.sensors.ui.GyroscopeFragment;
import com.example.kjoseph.sensors.ui.LinearAccelerationFragment;
import com.example.kjoseph.sensors.ui.MagneticFieldFragment;
import com.example.kjoseph.sensors.ui.PressureFragment;
import com.example.kjoseph.sensors.ui.ProximityFragment;
import com.example.kjoseph.sensors.ui.RotationVectorFragment;
import com.example.kjoseph.sensors.ui.TemperatureFragment;

public class SensorsSingleton {

    private static SensorsSingleton instance = null;

    private SensorsSingleton() {
        // Exists only to defeat instantiation.
    }

    public static SensorsSingleton getInstance() {
        if(instance == null) {
            instance = new SensorsSingleton();
        }
        return instance;
    }

    public Fragment getSensorFragment(int id){
        Fragment tempFrag = null;
        switch (id) {
            case 0:
                tempFrag = new AccelerometerFragment();
                break;
            case 1:
                tempFrag = new MagneticFieldFragment();
                break;
            case 2:
                tempFrag = new GravityFragment();
                break;
            case 3:
                tempFrag = new ProximityFragment();
                break;
            case 4:
                tempFrag = new PressureFragment();
                break;
            case 5:
                tempFrag = new TemperatureFragment();
                break;
            case 6:
                tempFrag = new LinearAccelerationFragment();
                break;
            case 7:
                tempFrag = new RotationVectorFragment();
                break;
            case 8:
                tempFrag = new GyroscopeFragment();
                break;
        }
        return tempFrag;
    }
}
