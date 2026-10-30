package com.mycompany.bikemaintenancetracker;

import java.util.ArrayList;

public class BicycleTracker {

    // Attributes
    private Bicycle bicycle;
    private ArrayList<Ride> rideHistory;

    // Constructor
    public BicycleTracker(Bicycle bicycle) {
        this.bicycle = bicycle;
        this.rideHistory = new ArrayList<>();
    }

    // Record a new ride
    public void recordRide(double distance) {
        Ride newRide = new Ride(distance);

        rideHistory.add(newRide);
        bicycle.addMileage(distance);
    }

    // Display ride history
    public void displayRideHistory() {
        System.out.println("--- Ride History ---");

        for (Ride ride : rideHistory) {
            System.out.println(ride.getDistance() + " km");
        }
    }

    // Display maintenance status
    public void displayMaintenanceStatus() {
        bicycle.checkMaintenance();
    }
}