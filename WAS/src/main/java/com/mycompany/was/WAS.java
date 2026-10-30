//missing array to store and access inheritance
//incomplete sout in case 2 for runners

package com.mycompany.was;

import java.util.Scanner;

public class WAS {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
        System.out.println("================================");
        System.out.println("    Workout Athlete System");
        System.out.println("================================");
      
        System.out.println("What kind of athlete are you: ");
        System.out.println("1. Cyclist");
        System.out.println("2. Runner");
        System.out.print("Choice:");
        int choice = input.nextInt();
        input.nextLine();
           
        switch (choice){
            case 1: 
                System.out.println("Enter Name: ");
                String name = input.nextLine();
                
                System.out.println("Enter Age: ");
                int age = input.nextInt();
                
                System.out.println("Enter Height: ");
                double height = input.nextDouble();
                
                System.out.println("Enter Weight: ");
                double weight = input.nextDouble();
                
                System.out.println("Enter max HR: ");
                int maxHr = input.nextInt();
                
                input.nextLine();
                System.out.println("Enter Bike (MTB/RB/GRAVEL): ");
                String bike = input.nextLine();
                
                System.out.println("Enter FTP: ");
                double ftp = input.nextDouble();
                
        System.out.println("\n=================================================================");
        System.out.println("                        CYCLIST SUMMARY");
        System.out.println("=================================================================");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s ", 
                "Name", "Age", "Height", "Weight", "max HR", "FTP");
        System.out.println("\n-----------------------------------------------------------------");
        
                break;
            case 2: 
                 System.out.println("Enter Name: ");
                 name = input.nextLine();
                
                System.out.println("Enter Age: ");
                 age = input.nextInt();
                
                System.out.println("Enter Height: ");
                 height = input.nextDouble();
                
                System.out.println("Enter Weight: ");
                 weight = input.nextDouble();
                
                System.out.println("Enter max HR: ");
                 maxHr = input.nextInt();
                 
                 System.out.println("Enter VO2 max: ");
                 double vo2max = input.nextDouble();
                 
                break;
            default: 
                System.out.println("Invalid choice");
                break;
        }    
      

        input.close();
    } 
}
