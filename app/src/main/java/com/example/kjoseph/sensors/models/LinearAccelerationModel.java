package com.example.kjoseph.sensors.models;

import android.content.Context;

public class LinearAccelerationModel extends DBHandler {

    public LinearAccelerationModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.LINEAR_ACCELERATION_TABLE;
    }

}
