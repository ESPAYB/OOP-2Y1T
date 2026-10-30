package com.mycompany.m1_simpledebug_hilario;

public class StudentProfileDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Student Profiles ===");
        // Create two StudentProfile objects
        StudentProfile student1 = new StudentProfile("2026-001", "Alice Smith", 88.5);
        StudentProfile student2 = new StudentProfile("2026-002", "Bob Johnson", 92.0);

        // Display both profiles
        System.out.println("\n=== Initial Profiles ===");
        student1.displayProfile();
        student2.displayProfile();

        // Perform one valid score update
        System.out.println("=== Test 1: Valid Score Update ===");
        student1.setQuizScore(95.0);
        student1.displayProfile();

        // Perform one invalid score update
        System.out.println("=== Test 2: Invalid Score Update ===");
        student2.setQuizScore(120.0); // Invalid score should be rejected
        student2.displayProfile();     // Verify score remains unchanged

        // Display total object count using the static getter
        System.out.println("=== Total Student Count ===");
        System.out.printf("Total StudentProfile objects created: %d%n", StudentProfile.getStudentCount());
    }
}
