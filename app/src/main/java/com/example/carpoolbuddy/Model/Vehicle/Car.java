package com.example.carpoolbuddy.Model.Vehicle;

import java.util.ArrayList;

public class Car extends Vehicle {
    private int range;

    public Car(String s, String uid, String ownerString, String modelString, int range, String biweightCapacity) {
        super();
    }

    public Car(String owner, String modal, String vehicleID, String vehicleType, double basePrice) {
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
