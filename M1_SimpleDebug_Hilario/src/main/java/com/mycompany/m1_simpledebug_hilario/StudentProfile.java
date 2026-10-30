package com.mycompany.m1_simpledebug_hilario;

public class StudentProfile {
    // Private instance fields
    private String studentId;
    private String studentName;
    private double quizScore;

    // Private static field shared by all instances
    private static int studentCount = 0;

    // Constructor using 'this' to initialize instance fields and increment studentCount
    public StudentProfile(String studentId, String studentName, double quizScore) {
        this.studentId = studentId;
        this.studentName = studentName;

        // Validate initial score using the setter logic
        if (quizScore >= 0 && quizScore <= 100) {
            this.quizScore = quizScore;
        } else {
            System.out.printf("Invalid initial score (%.1f) for %s. Defaulting score to 0.0.%n", quizScore, studentName);
            this.quizScore = 0.0;
        }

        studentCount++; // Increment total object count
    }

    // Getters
    public String getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public double getQuizScore() {
        return this.quizScore;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    // Validated Setter: accepts only 0 to 100
    public void setQuizScore(double quizScore) {
        if (quizScore >= 0 && quizScore <= 100) {
            this.quizScore = quizScore;
            System.out.printf("Successfully updated quiz score for %s to %.1f.%n", this.studentName, quizScore);
        } else {
            System.out.printf("Error: Score %.1f is invalid. Score for %s remains unchanged (%.1f).%n", 
                              quizScore, this.studentName, this.quizScore);
        }
    }

    // Display student profile details
    public void displayProfile() {
        System.out.println("----------------------------------------");
        System.out.printf("Student ID   : %s%n", this.studentId);
        System.out.printf("Student Name : %s%n", this.studentName);
        System.out.printf("Quiz Score   : %.2f%n", this.quizScore);
        System.out.println("----------------------------------------");
    }
}
