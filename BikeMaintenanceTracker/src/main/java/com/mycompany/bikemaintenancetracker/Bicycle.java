package com.mycompany.bikemaintenancetracker;

import java.util.ArrayList;

public class Bicycle {

    // Attributes
    private String bicycleName;
    private String bicycleType;
    private double totalMileage;
    private ArrayList<MaintenanceItem> components;

    // Constructor
    public Bicycle(String bicycleName, String bicycleType) {
        this.bicycleName = bicycleName;
        this.bicycleType = bicycleType;
        this.totalMileage = 0;
        this.components = new ArrayList<>();
    }

    // Add a component
    public void addComponent(MaintenanceItem item) {
        components.add(item);
    }

    // Add mileage to bicycle and components
    public void addMileage(double km) {
        totalMileage += km;

        for (MaintenanceItem component : components) {
            component.addMileage(km);
        }
    }

    // Display bicycle information
    public void displayBicycleInfo() {
        System.out.println("--- Bicycle Information ---");
        System.out.println("Name: " + bicycleName);
        System.out.println("Type: " + bicycleType);
        System.out.println("Total Mileage: " + totalMileage + " km");
    }

    // Check maintenance of all components
    public void checkMaintenance() {
        System.out.println("--- Maintenance Status ---");

        for (MaintenanceItem component : components) {
            component.displayStatus();
            System.out.println();
        }
    }

    // Getters
    public String getBicycleName() {
        return bicycleName;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public double getTotalMileage() {
        return totalMileage;
    }

    public ArrayList<MaintenanceItem> getComponents() {
        return new ArrayList<>(components);
    }
}