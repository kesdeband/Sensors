package com.example.kjoseph.sensors.models;

import android.content.Context;

public class GyroscopeModel extends DBHandler {

    public GyroscopeModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.GYROSCOPE_TABLE;
    }

}
