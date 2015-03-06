package com.example.kjoseph.sensors.models;

import android.content.Context;

public class PressureModel extends DBHandler {

    public PressureModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.PRESSURE_TABLE;
    }

}
