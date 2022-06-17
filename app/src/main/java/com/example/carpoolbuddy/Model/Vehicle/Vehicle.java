package com.example.carpoolbuddy.Model.Vehicle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable, Parcelable {
    private String owner;
    private String modal;
    private int capacity;
    private String vehicleID;
    private ArrayList ridersUIDS;
    private boolean open;
    private String vehicleType;
    private double basePrice;

    public Vehicle(){
        this.owner = " ";
        this.modal = " ";
        this.capacity = 0;
        this.vehicleID = " ";
        this.ridersUIDS = new ArrayList();
        this.open = false;
        this.vehicleType = " ";
        this.basePrice = 0;
    }

    public Vehicle(String owner, String modal, int capacity, String vehicleID, ArrayList ridersUIDS, boolean open, String vehicleType, double basePrice) {
        this.owner = owner;
        this.modal = modal;
        this.capacity = capacity;
        this.vehicleID = vehicleID;
        this.ridersUIDS = ridersUIDS;
        this.open = open;
        this.vehicleType = vehicleType;
        this.basePrice = basePrice;
    }

    public Vehicle(String uid, String ownerString, String modelString, int priceString, String bitype, int biweight, int biweightCapacity) {

    }

    protected Vehicle(Parcel in) {
        owner = in.readString();
        modal = in.readString();
        capacity = in.readInt();
        vehicleID = in.readString();
        open = in.readByte() != 0;
        vehicleType = in.readString();
        basePrice = in.readDouble();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public void addRidersUID(String rider){this.ridersUIDS.add(rider);}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public ArrayList getRidersUIDS() {
        return ridersUIDS;
    }

    public void setRidersUIDS(ArrayList ridersUIDS) {
        this.ridersUIDS = ridersUIDS;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                ", modal='" + modal + '\'' +
                ", capacity=" + capacity +
                ", vehicleID='" + vehicleID + '\'' +
                ", ridersUIDS=" + ridersUIDS +
                ", open=" + open +
                ", vehicleType='" + vehicleType + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(owner);
        dest.writeString(modal);
        dest.writeInt(capacity);
        dest.writeString(vehicleID);
        dest.writeByte((byte) (open ? 1 : 0));
        dest.writeString(vehicleType);
        dest.writeDouble(basePrice);
    }
}
