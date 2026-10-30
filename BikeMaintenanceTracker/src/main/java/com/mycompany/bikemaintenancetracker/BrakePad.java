package com.mycompany.bikemaintenancetracker;

public class BrakePad extends MaintenanceItem {

    // Constructor
    public BrakePad(double serviceInterval) {
        super("Brake Pad", serviceInterval);
    }

    // Brake pad-specific maintenance check
    @Override
    public boolean needsMaintenance() {
        return getMileageSinceService() >= getServiceInterval();
    }

    // Brake pad-specific status display
    @Override
    public void displayStatus() {
        System.out.println("--- Brake Pad Status ---");
        System.out.println("Mileage Since Service: "
                + getMileageSinceService() + " km");
        System.out.println("Service Interval: "
                + getServiceInterval() + " km");

        if (needsMaintenance()) {
            System.out.println("Status: Brake pad maintenance needed!");
        } else {
            System.out.println("Status: Brake pad is good.");
        }
    }
}