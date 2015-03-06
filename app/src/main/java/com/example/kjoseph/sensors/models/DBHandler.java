package com.example.kjoseph.sensors.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class DBHandler extends SQLiteOpenHelper implements BaseColumns {

    protected static String DB_TABLE_NAME = "";

    public DBHandler(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
        Log.d("create", "database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("create", "tables created");
        db.execSQL(DBOps.CREATE_ACCELEROMETER_TABLE);
        db.execSQL(DBOps.CREATE_MAGNETIC_FIELD_TABLE);
        db.execSQL(DBOps.CREATE_GRAVITY_TABLE);
        db.execSQL(DBOps.CREATE_PROXIMITY_TABLE);
        db.execSQL(DBOps.CREATE_PRESSURE_TABLE);
        db.execSQL(DBOps.CREATE_TEMPERATURE_TABLE);
        db.execSQL(DBOps.CREATE_LINEAR_ACCELERATION_TABLE);
        db.execSQL(DBOps.CREATE_ROTATION_VECTOR_TABLE);
        db.execSQL(DBOps.CREATE_GYROSCOPE_TABLE);
    }

    public boolean insertValues(Sensor sensor) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.COLUMN_X_AXIS, sensor.getX_axis());
        values.put(DBContract.COLUMN_Y_AXIS, sensor.getY_axis());
        values.put(DBContract.COLUMN_Z_AXIS, sensor.getZ_axis());
        values.put(DBContract.COLUMN_TIME, DBContract.dFormat.format(new Date()));

        long result = db.insert(DB_TABLE_NAME, null, values);
        db.close();
        return (result > 0);
    }

    public List<Sensor> retrieveAllValues() {
        List<Sensor> sensors = new ArrayList<>();
        String query = "SELECT * FROM " + DB_TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                sensors.add(new Sensor(cursor.getFloat(1), cursor.getFloat(2), cursor.getFloat(3)));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return sensors;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(db);
    }

    public static abstract class DBOps implements BaseColumns {

        // Create accelerometer table
        public static final String CREATE_ACCELEROMETER_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.ACCELEROMETER_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create magnetic field table
        public static final String CREATE_MAGNETIC_FIELD_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.MAGNETIC_FIELD_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create gravity table
        public static final String CREATE_GRAVITY_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.GRAVITY_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create proximity table
        public static final String CREATE_PROXIMITY_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.PROXIMITY_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create pressue table
        public static final String CREATE_PRESSURE_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.PRESSURE_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create temperature table
        public static final String CREATE_TEMPERATURE_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.TEMPERATURE_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create linear acceleration table
        public static final String CREATE_LINEAR_ACCELERATION_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.LINEAR_ACCELERATION_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create rotation vector table
        public static final String CREATE_ROTATION_VECTOR_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.ROTATION_VECTOR_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

        // Create gyroscope table
        public static final String CREATE_GYROSCOPE_TABLE =

                "CREATE TABLE IF NOT EXISTS " +
                        DBContract.GYROSCOPE_TABLE + " (" +
                        _ID + DBContract.INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                        DBContract.COLUMN_X_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Y_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_Z_AXIS + DBContract.REAL_TYPE + DBContract.COMMA_SEP +
                        DBContract.COLUMN_TIME + DBContract.TIMESTAMP + ")";

    }
}
