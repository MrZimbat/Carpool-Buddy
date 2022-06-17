package com.example.carpoolbuddy.Model.User;

import java.util.ArrayList;

public class Student extends User {
    private int graduatingYear;
    private ArrayList parentUIDs;

    public Student(String uid, String name, String email, String userType, double priceMultiplier, ArrayList ownedVehicle, int graduatingYear, ArrayList parentUIDs) {
        super(uid, name, email, userType, priceMultiplier, ownedVehicle);
        this.graduatingYear = graduatingYear;
        this.parentUIDs = parentUIDs;
    }

    public int getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(int graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    public ArrayList getParentUIDs() {
        return parentUIDs;
    }

    public void setParentUIDs(ArrayList parentUIDs) {
        this.parentUIDs = parentUIDs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "graduatingYear='" + graduatingYear + '\'' +
                ", parentUIDs=" + parentUIDs +
                '}';
    }
}
