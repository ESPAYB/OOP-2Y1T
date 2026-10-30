package com.mycompany.m4a1_hilario;

public class Vehicle {
    private String vehicleName;

    // Constructor to initialize vehicleName
    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    // Getter for vehicleName
    public String getVehicleName() {
        return vehicleName;
    }

    // General movement message
    public String describeMovement() {
        return vehicleName + " is moving around the campus.";
    }
}