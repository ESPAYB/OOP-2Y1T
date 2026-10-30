package com.mycompany.m1_simpledebug_hilario;

import java.util.Scanner;

public class ThreeScoreCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read student name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        // Array to store 3 whole-number quiz scores
        int[] scores = new int[3];

        // Read scores
        System.out.print("Enter Quiz 1 score: ");
        scores[0] = scanner.nextInt();

        System.out.print("Enter Quiz 2 score: ");
        scores[1] = scanner.nextInt();

        System.out.print("Enter Quiz 3 score: ");
        scores[2] = scanner.nextInt();

        // Calculate total score using arithmetic operators
        int total = scores[0] + scores[1] + scores[2];

        // Define constant for passing threshold
        final double PASSING_SCORE = 75.0;

        // Calculate average using explicit casting
        double average = (double) total / scores.length;

        // Determine passing status
        boolean passed = average >= PASSING_SCORE;

        // Summary output
        System.out.println("\n----------------------------------------");
        System.out.println("            STUDENT SUMMARY             ");
        System.out.println("----------------------------------------");
        System.out.printf("Student Name : %s%n", name);
        System.out.printf("Scores       : %d, %d, %d%n", scores[0], scores[1], scores[2]);
        System.out.printf("Total Score  : %d%n", total);
        System.out.printf("Average      : %.2f%n", average);
        System.out.printf("Passed Status: %b%n", passed);
        System.out.println("----------------------------------------");

        scanner.close();
    }
}
