package com.mycompany.bikemaintenancetracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== BICYCLE MAINTENANCE TRACKER ===");

        // Bicycle setup
        System.out.print("Enter bicycle name: ");
        String bicycleName = input.nextLine();

        System.out.print("Enter bicycle type: ");
        String bicycleType = input.nextLine();

        Bicycle bike = new Bicycle(bicycleName, bicycleType);

        // Maintenance setup
        System.out.println("\n--- Maintenance Setup ---");

        System.out.print("Enter chain service interval (km): ");
        double chainInterval = input.nextDouble();

        System.out.print("Enter tire service interval (km): ");
        double tireInterval = input.nextDouble();

        System.out.print("Enter brake pad service interval (km): ");
        double brakeInterval = input.nextDouble();

        // Create components
        Chain chain = new Chain(chainInterval);
        Tire tire = new Tire(tireInterval);
        BrakePad brakePad = new BrakePad(brakeInterval);

        // Add components to bicycle
        bike.addComponent(chain);
        bike.addComponent(tire);
        bike.addComponent(brakePad);

        // Create tracker
        BicycleTracker tracker = new BicycleTracker(bike);

        int choice;

        // Repeating menu
        do {

            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Record Ride");
            System.out.println("2. View Bicycle Information");
            System.out.println("3. View Ride History");
            System.out.println("4. Check Maintenance");
            System.out.println("5. Service Component");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("\nEnter distance traveled (km): ");
                    double distance = input.nextDouble();

                    if (distance > 0) {
                        tracker.recordRide(distance);
                        System.out.println("Ride recorded successfully.");
                    } else {
                        System.out.println("Distance must be greater than 0.");
                    }

                    break;

                case 2:
                    System.out.println();
                    bike.displayBicycleInfo();
                    break;

                case 3:
                    System.out.println();
                    tracker.displayRideHistory();
                    break;

                case 4:
                    System.out.println();
                    tracker.displayMaintenanceStatus();
                    break;

                case 5:

                    System.out.println("\n--- Service Component ---");
                    System.out.println("1. Chain");
                    System.out.println("2. Tire");
                    System.out.println("3. Brake Pad");

                    System.out.print("Choose component: ");
                    int componentChoice = input.nextInt();

                    switch (componentChoice) {

                        case 1:
                            chain.resetMileage();
                            System.out.println("Chain has been serviced.");
                            break;

                        case 2:
                            tire.resetMileage();
                            System.out.println("Tire has been serviced.");
                            break;

                        case 3:
                            brakePad.resetMileage();
                            System.out.println("Brake pad has been serviced.");
                            break;

                        default:
                            System.out.println("Invalid component.");
                    }

                    break;

                case 6:
                    System.out.println("\nExiting Bicycle Maintenance Tracker...");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            // end of switch

            // ADD PAUSE HERE
            if (choice != 6) {
                System.out.println("\nPress Enter to continue...");
                input.nextLine();
                input.nextLine();
            }
        } while (choice != 6);

        input.close();
    }
}