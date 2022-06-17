package com.example.carpoolbuddy.Model.User;

import java.util.ArrayList;

public class Alumni extends User {
    private int graduateYear;

    public Alumni(String uid, String name, String email, String userType, double priceMultiplier, ArrayList ownedVehicle, int graduateYear) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicle);
        this.graduateYear = graduateYear;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "graduateYear='" + graduateYear + '\'' +
                '}';
    }
}
