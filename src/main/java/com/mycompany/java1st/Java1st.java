

package com.mycompany.java1st;

import java.util.Scanner;


public class Java1st {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first Number:");
        double num1 = scanner.nextDouble();
        
        System.out.println("Enter second Number: ");
        double num2 = scanner.nextDouble();
        
        System.out.println("choose operation (Addition, Subtraction, Multiplication, Division) : ");
        int choice = scanner.nextInt();
        
        switch (choice){
            case 1: System.out.println("Result: " + (num1 + num2));
            break;
            case 2: System.out.println("Result: " + (num1 - num2));
            break;
            case 3: System.out.println("Result: " + (num1 * num2));
            break;
            case 4: System.out.println("Result: " + (num1 / num2));
            break;
            default: System.out.println("Invalid choice");
        }
        scanner.close();
    }
}
