package com.example.kjoseph.sensors.ui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.kjoseph.sensors.R;

public abstract class SensorDetailsFragment extends Fragment implements SensorEventListener {

    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_POSITION = "item_pos";

    protected String senorName;
    protected int sensorDescription;

    protected SensorManager sensorManager;
    protected Sensor sensor;
    protected int sensorType;

    protected TextView txt_x_axis;
    protected TextView txt_y_axis;
    protected TextView txt_z_axis;
    protected TextView txt_accuracy;
    protected TextView txt_sensor_description;
    protected TextView lbl_toggle_btn;
    protected Button btnStart;
    protected ToggleButton toggleOnOff;
    protected String sensorDetails [];

    protected boolean sensorStarted = false;

    public SensorDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ITEM_NAME))
            this.senorName = getArguments().getString(ITEM_NAME);

        if (getArguments().containsKey(ITEM_POSITION))
            this.sensorDescription = getArguments().getInt(ITEM_POSITION);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(this.sensorType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_details_sensors, container, false);
        txt_x_axis = (TextView) view.findViewById(R.id.txt_x_axis);
        txt_y_axis = (TextView) view.findViewById(R.id.txt_y_axis);
        txt_z_axis = (TextView) view.findViewById(R.id.txt_z_axis);
        txt_accuracy = (TextView) view.findViewById(R.id.txt_accuracy);
        lbl_toggle_btn = (TextView) view.findViewById(R.id.lbl_toggle_btn);
        lbl_toggle_btn.setText("Toggle " + String.valueOf(this.senorName));
        txt_sensor_description = (TextView) view.findViewById(R.id.txt_sensor_description);
        sensorDetails = getResources().getStringArray(R.array.sensorDescription);
        txt_sensor_description.setText(String.valueOf(sensorDetails[this.sensorDescription]));

        btnStart = (Button) view.findViewById(R.id.btnStart);
        toggleOnOff = (ToggleButton) view.findViewById(R.id.toggleOnOff);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSensor();
            }
        });

        toggleOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sensorStarted) {
                    // Is the toggle on?
                    boolean on = ((ToggleButton) v).isChecked();
                    if(!on) {
                        pauseSensor();
                    } else {
                        resumeSensor();
                    }
                }
                else {
                    toggleOnOff.setChecked(false);
                    Toast.makeText(getActivity(), "Start sensor first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void startSensor() {
        if(sensor != null) { // Register Listener
            if(!sensorStarted) {
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                toggleOnOff.toggle();
                sensorStarted = true;
                Toast.makeText(getActivity(), this.senorName + " found", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getActivity(), "Use toggle button to pause/resume", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getActivity(), this.senorName + " not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void pauseSensor() {
        sensorManager.unregisterListener(this);
        Toast.makeText(getActivity(), this.senorName + " paused", Toast.LENGTH_SHORT).show();
    }

    public void resumeSensor() {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        Toast.makeText(getActivity(), this.senorName + " resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(sensorStarted && toggleOnOff.isChecked())
            toggleOnOff.toggle();
        sensorManager.unregisterListener(this); // unregister listener
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        txt_x_axis.setText(String.valueOf(x));
        txt_y_axis.setText(String.valueOf(y));
        txt_z_axis.setText(String.valueOf(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        txt_accuracy.setText(String.valueOf(accuracy));
    }
}
