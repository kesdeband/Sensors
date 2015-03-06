package com.example.kjoseph.sensors.models;

import android.content.Context;

public class GravityModel extends DBHandler {

    public GravityModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.GRAVITY_TABLE;
    }

}
