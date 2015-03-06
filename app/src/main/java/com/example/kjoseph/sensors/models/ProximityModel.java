package com.example.kjoseph.sensors.models;

import android.content.Context;

public class ProximityModel extends DBHandler {

    public ProximityModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.PROXIMITY_TABLE;
    }

}
