package com.example.carpoolbuddy.Model.Vehicle;

import java.util.ArrayList;

public class Car extends Vehicle {
    private int range;

    public Car() {
        super();
    }

    public Car(String owner, String modal, int capacity, String vehicleID, ArrayList ridersUIDS, boolean open, String vehicleType, double basePrice, int range) {
        super(owner, modal, capacity, vehicleID, ridersUIDS, open, vehicleType, basePrice);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Car{" +
                "range=" + range +
                '}';
    }
}
