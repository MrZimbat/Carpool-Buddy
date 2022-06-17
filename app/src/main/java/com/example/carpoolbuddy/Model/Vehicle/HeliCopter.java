package com.example.carpoolbuddy.Model.Vehicle;

import java.util.ArrayList;

public class HeliCopter extends Vehicle {
    private int maxAltitude;
    private int maxAirSpeed;


    public HeliCopter(String owner, String modal, int capacity, String vehicleID, ArrayList ridersUIDS, boolean open, String vehicleType, double basePrice, int maxAltitude, int maxAirSpeed) {
        super(owner, modal, capacity, vehicleID, ridersUIDS, open, vehicleType, basePrice);
        this.maxAltitude = maxAltitude;
        this.maxAirSpeed = maxAirSpeed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAirSpeed() {
        return maxAirSpeed;
    }

    public void setMaxAirSpeed(int maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    @Override
    public String toString() {
        return "HeliCopter{" +
                "maxAltitude=" + maxAltitude +
                ", maxAirSpeed=" + maxAirSpeed +
                '}';
    }
}
