package com.example.kjoseph.sensors.models;

import android.content.Context;

public class RotationVectorModel extends DBHandler {

    public RotationVectorModel(Context context) {
        super(context);
        DBHandler.DB_TABLE_NAME = DBContract.ROTATION_VECTOR_TABLE;
    }

}
