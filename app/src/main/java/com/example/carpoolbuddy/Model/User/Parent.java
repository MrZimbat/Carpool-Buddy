package com.example.carpoolbuddy.Model.User;

import com.example.carpoolbuddy.Model.User.User;

import java.util.ArrayList;

public class Parent extends User {
    private ArrayList childUIDs;



    public Parent(String uid, String name, String email, String userType, double priceMultiplier, ArrayList ownedVehicle, ArrayList childUIDs) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicle);
        this.childUIDs = childUIDs;
    }

    public ArrayList getChildUIDs() {
        return childUIDs;
    }

    public void setChildUIDs(ArrayList childUIDs) {
        this.childUIDs = childUIDs;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "childUIDs=" + childUIDs +
                '}';
    }
}
