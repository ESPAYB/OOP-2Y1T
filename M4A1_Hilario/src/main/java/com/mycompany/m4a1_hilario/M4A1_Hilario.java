/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.m4a1_hilario;

/**
 *
 * @author genea
 */
public class M4A1_Hilario {
        public static void main(String[] args) {
        // Instantiate a general Vehicle and a specialized Bus
        Vehicle generalVehicle = new Vehicle("Campus Security Cart");
        Bus campusBus = new Bus("Main Express Shuttle", 45);

        // Display movement descriptions
        System.out.println("--- Movement Descriptions ---");
        System.out.println("Vehicle: " + generalVehicle.describeMovement());
        System.out.println("Bus: " + campusBus.describeMovement());

        // Explanation of inherited and overridden behaviors
        System.out.println("\n--- Inheritance & Polymorphism Explanation ---");
        System.out.println("1. Inherited Behavior:");
        System.out.println("   - The Bus class inherited the 'vehicleName' attribute and its getter 'getVehicleName()' from the Vehicle superclass via 'extends'.");
        System.out.println("   - The Bus constructor initialized the inherited name using 'super(vehicleName)'.");
        
        System.out.println("\n2. Overridden Behavior:");
        System.out.println("   - The 'describeMovement()' method was overridden in Bus using the '@Override' annotation.");
        System.out.println("   - Inside Bus, 'super.describeMovement()' was called to reuse the superclass implementation, and then extended by appending the bus capacity details.");
    }
}
