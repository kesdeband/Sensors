package com.example.kjoseph.sensors.models;

public class Sensor {

    private float x_axis;
    private float y_axis;
    private float z_axis;

    public Sensor(float x, float y, float z) {
        this.x_axis = x;
        this.y_axis = y;
        this.z_axis = z;
    }

    public float getX_axis() {
        return this.x_axis;
    }

    public float getY_axis() {
        return this.y_axis;
    }

    public float getZ_axis() {
        return this.z_axis;
    }
}
