package com.mycompany.bikemaintenancetracker;

public class Tire extends MaintenanceItem {

    // Constructor
    public Tire(double serviceInterval) {
        super("Tire", serviceInterval);
    }

    // Tire-specific maintenance check
    @Override
    public boolean needsMaintenance() {
        return getMileageSinceService() >= getServiceInterval();
    }

    // Tire-specific status display
    @Override
    public void displayStatus() {
        System.out.println("--- Tire Status ---");
        System.out.println("Mileage Since Service: "
                + getMileageSinceService() + " km");
        System.out.println("Service Interval: "
                + getServiceInterval() + " km");

        if (needsMaintenance()) {
            System.out.println("Status: Tire maintenance needed!");
        } else {
            System.out.println("Status: Tire is good.");
        }
    }
}