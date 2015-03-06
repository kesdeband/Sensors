package com.example.kjoseph.sensors.models;

import java.text.SimpleDateFormat;

public final class DBContract {

    // If you change the database schema, you must increment the database version.
    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "sensors.db";
    public final static SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public final static String COLUMN_X_AXIS = "xaxis";
    public final static String COLUMN_Y_AXIS = "yaxis";
    public final static String COLUMN_Z_AXIS = "zaxis";
    public final static String COLUMN_TIME = "time";

    public final static String COMMA_SEP = ",";
    public final static String INT_TYPE = " INTEGER";
    public final static String REAL_TYPE = " REAL";
    public final static String TIMESTAMP = " DATETIME DEFAULT CURRENT_TIMESTAMP";

    public final static String ACCELEROMETER_TABLE = "accelerometer";
    public final static String MAGNETIC_FIELD_TABLE = "magnetic_field";
    public final static String GRAVITY_TABLE = "gravity";
    public final static String PROXIMITY_TABLE = "proximity";
    public final static String PRESSURE_TABLE = "pressure";
    public final static String TEMPERATURE_TABLE = "temperature";
    public final static String LINEAR_ACCELERATION_TABLE = "linear_acceleration";
    public final static String ROTATION_VECTOR_TABLE = "rotation_vector";
    public final static String GYROSCOPE_TABLE = "gyroscope";
    public final static String GPS_TABLE = "gps";

    public DBContract() {} // Empty constructor

}
