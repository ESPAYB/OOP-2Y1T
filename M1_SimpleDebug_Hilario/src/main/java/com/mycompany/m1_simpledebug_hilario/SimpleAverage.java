package com.mycompany.m1_simpledebug_hilario;

public class SimpleAverage {
public static void main(String[] args) { 
    int[] scores = {80, 90, 70};
    
int total = 0; //no semicolon

for (int i = 0; i < scores.length; i++) { 
    total += scores[i];
    }

double average = total / 3; //it should be 3, not 4
System.out.println("Average: " + average); 
    }
}

