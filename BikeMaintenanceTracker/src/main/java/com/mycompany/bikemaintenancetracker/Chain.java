package com.mycompany.bikemaintenancetracker;

public class Chain extends MaintenanceItem {

    // Constructor
    public Chain(double serviceInterval) {
        super("Chain", serviceInterval);
    }

    // Chain-specific maintenance check
    @Override
    public boolean needsMaintenance() {
        return getMileageSinceService() >= getServiceInterval();
    }

    // Chain-specific status display
    @Override
    public void displayStatus() {
        System.out.println("--- Chain Status ---");
        System.out.println("Mileage Since Service: "
                + getMileageSinceService() + " km");
        System.out.println("Service Interval: "
                + getServiceInterval() + " km");

        if (needsMaintenance()) {
            System.out.println("Status: Chain maintenance needed!");
        } else {
            System.out.println("Status: Chain is good.");
        }
    }
}