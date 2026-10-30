package com.mycompany.hospitalinpatientbillingandinsurancesystem;

import java.util.Scanner;

public class HIPBIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println(" ST. JUDE MEDICAL CENTER - IN-PATIENT BILLING ");
        System.out.println("=================================================");
        
        System.out.print("Enter the total number of patients to process: ");
        int totalPatients = scanner.nextInt();
        scanner.nextLine(); // Clear newline buffer

        InPatient[] patients = new InPatient[totalPatients];

        // Sequential input loop
        for (int i = 0; i < totalPatients; i++) {
            System.out.println("\n--- Entering Details for Patient #" + (i + 1) + " ---");

            System.out.print("Enter Patient ID: ");
            String patientId = scanner.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            // Input Validation: Age
            int age;
            do {
                System.out.print("Enter Age: ");
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Invalid input! Age cannot be negative. Try again.");
                }
            } while (age < 0);

            // Input Validation: Days Stayed
            int daysStayed;
            do {
                System.out.print("Enter Days Stayed: ");
                daysStayed = scanner.nextInt();
                if (daysStayed < 0) {
                    System.out.println("Invalid input! Days stayed cannot be negative. Try again.");
                }
            } while (daysStayed < 0);

            // Input Validation: Daily Rate
            double dailyRate;
            do {
                System.out.print("Enter Daily Room Rate: ");
                dailyRate = scanner.nextDouble();
                if (dailyRate < 0) {
                    System.out.println("Invalid input! Daily rate cannot be negative. Try again.");
                }
            } while (dailyRate < 0);

            // Input Validation: Medication Cost
            double medicationCost;
            do {
                System.out.print("Enter Medication Cost: ");
                medicationCost = scanner.nextDouble();
                if (medicationCost < 0) {
                    System.out.println("Invalid input! Medication cost cannot be negative. Try again.");
                }
            } while (medicationCost < 0);

            System.out.print("Has Insurance? (true/false): ");
            boolean hasInsurance = scanner.nextBoolean();
            scanner.nextLine(); // Clear newline buffer

            // Instantiating patient object into array
            patients[i] = new InPatient(patientId, name, age, daysStayed, dailyRate, medicationCost, hasInsurance);
        }

        // Output Loop - Tabular Billing Statement
        System.out.println("\n========================================================================================================");
        System.out.println("                                FINAL IN-PATIENT BILLING REPORT                                         ");
        System.out.println("========================================================================================================");
        System.out.printf("%-10s %-18s %-5s %-12s %-12s %-12s %-10s %-12s%n", 
                "ID", "Name", "Age", "Days Stayed", "Daily Rate", "Med Cost", "Insurance", "Final Bill");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < patients.length; i++) {
            InPatient p = patients[i];
            System.out.printf("%-10s %-18s %-5d %-12d $%-11.2f $%-11.2f %-10s $%-11.2f%n",
                    p.getPatientId(),
                    p.getName(),
                    p.getAge(),
                    p.getDaysStayed(),
                    p.getDailyRate(),
                    p.getMedicationCost(),
                    p.isHasInsurance() ? "Yes" : "No",
                    p.getFinalBill());
        }
        System.out.println("========================================================================================================\n");
        
        scanner.close();
    }
}