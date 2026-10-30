package com.mycompany.m1_simpledebug_hilario;

public class ReusableScoreAnalyzer { 
    public static void main(String[] args) {
        int[] scores = {60, 70, 65};
        double average = calculateAverage(scores);

        System.out.printf("Average: %.2f%n", average); 
        System.out.println("Remark: " + getRemark(average));
    }

    static double calculateAverage(int[] scores) {
        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];    
        }
        return total / scores.length;
    }

    static String getRemark(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 75) {
            return "Passed";
        } else {
            return "Needs Improvement";
        }
    }
}