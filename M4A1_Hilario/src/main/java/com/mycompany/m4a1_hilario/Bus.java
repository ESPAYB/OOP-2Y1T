package com.mycompany.m4a1_hilario;

public class Bus extends Vehicle {
    private int capacity;

    // Constructor using super to initialize vehicleName and setting capacity
    public Bus(String vehicleName, int capacity) {
        super(vehicleName);
        this.capacity = capacity;
    }

    // Overridden method reusing superclass message and adding bus capacity
    @Override
    public String describeMovement() {
        return super.describeMovement() + " It has a passenger capacity of " + capacity + ".";
    }
}
