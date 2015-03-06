package com.example.kjoseph.sensors.models;

import android.content.Context;

public class TemperatureModel extends DBHandler {

    public TemperatureModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.TEMPERATURE_TABLE;
    }

}
