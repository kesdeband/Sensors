package com.example.kjoseph.sensors.ui;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.kjoseph.sensors.models.GravityModel;

public class GravityFragment extends SensorDetailsFragment {

    private GravityModel database;

    public GravityFragment() {
        super();
        this.sensorType = Sensor.TYPE_GRAVITY;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        database = new GravityModel(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        super.onSensorChanged(event);
        new SensorEventLoggerTask().execute(event);
    }

    private class SensorEventLoggerTask extends AsyncTask<SensorEvent, Void, Boolean> {

        @Override
        protected Boolean doInBackground(SensorEvent... events) {
            SensorEvent event = events[0];
            // record the values
            return database.insertValues(new com.example.kjoseph.sensors.models.Sensor(event.values[0], event.values[1], event.values[2]));
        }

        @Override
        protected void onPostExecute(Boolean recorded) {
            if(recorded)
                Log.d("Gravity", "Sensor data saved!");
        }
    }
}
