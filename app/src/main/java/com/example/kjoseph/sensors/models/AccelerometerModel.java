package com.example.kjoseph.sensors.models;

import android.content.Context;

public class AccelerometerModel extends DBHandler {

    public AccelerometerModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.ACCELEROMETER_TABLE;
    }

}
