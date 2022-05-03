package com.example.carpoolbuddy.Model.Vehicle;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
    private String bycicleType;
    private int weight;
    private int weightCapacity;

    public Bicycle(String s, String uid, String ownerString, String modelString, String bitype, int biweight, int biweightCapacity){
        super();
    }

    public Bicycle(String owner, String modal, int capacity, String vehicleID, ArrayList ridersUIDS, boolean open, String vehicleType, double basePrice, String bycicleType, int weight, int weightCapacity) {
        super(owner, modal, capacity, vehicleID, ridersUIDS, open, vehicleType, basePrice);
        this.bycicleType = bycicleType;
        this.weight = weight;
        this.weightCapacity = weightCapacity;
    }

    public String getBycicleType() {
        return bycicleType;
    }

    public void setBycicleType(String bycicleType) {
        this.bycicleType = bycicleType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }
}
