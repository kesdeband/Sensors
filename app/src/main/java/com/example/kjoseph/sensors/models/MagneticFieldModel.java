package com.example.kjoseph.sensors.models;

import android.content.Context;

public class MagneticFieldModel extends DBHandler {

    public MagneticFieldModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.MAGNETIC_FIELD_TABLE;
    }

}
