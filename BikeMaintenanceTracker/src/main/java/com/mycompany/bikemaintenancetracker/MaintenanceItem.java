package com.mycompany.bikemaintenancetracker;

public abstract class MaintenanceItem implements Maintainable {

    // Attributes
    private String componentName;
    private double serviceInterval;
    private double mileageSinceService;

    // Constructor
    public MaintenanceItem(String componentName, double serviceInterval) {
        this.componentName = componentName;
        this.serviceInterval = serviceInterval;
        this.mileageSinceService = 0;
    }

    // Add mileage
    public void addMileage(double km) {
        mileageSinceService += km;
    }

    // Reset mileage after maintenance
    @Override
    public void resetMileage() {
        mileageSinceService = 0;
    }

    // Check if maintenance is needed
    @Override
    public boolean needsMaintenance() {
        return mileageSinceService >= serviceInterval;
    }

    // Display maintenance status
    @Override
    public abstract void displayStatus();

    // Getters
    public String getComponentName() {
        return componentName;
    }

    public double getServiceInterval() {
        return serviceInterval;
    }

    public double getMileageSinceService() {
        return mileageSinceService;
    }
}