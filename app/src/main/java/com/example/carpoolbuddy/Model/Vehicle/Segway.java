package com.example.carpoolbuddy.Model.Vehicle;

import java.util.ArrayList;

public class Segway extends Vehicle {
    private int range;
    private int weightCopacity;



    public Segway(String owner, String modal, int capacity, String vehicleID, ArrayList ridersUIDS, boolean open, String vehicleType, double basePrice, int range, int weightCopacity) {
        super(owner, modal, capacity, vehicleID, ridersUIDS, open, vehicleType, basePrice);
        this.range = range;
        this.weightCopacity = weightCopacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeightCopacity() {
        return weightCopacity;
    }

    public void setWeightCopacity(int weightCopacity) {
        this.weightCopacity = weightCopacity;
    }

    @Override
    public String toString() {
        return "Segway{" +
                "range=" + range +
                ", weightCopacity=" + weightCopacity +
                '}';
    }
}
