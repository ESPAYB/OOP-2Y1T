/*
 Gene Andrei B. HIlario TA21
 */
package com.mycompany.java1st;

import java.util.Scanner;

public class BankAccountRecord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Account holder: ");
        String accHolder = input.nextLine();
        
        System.out.println("Enter Account number: ");
        String accNumber = input.nextLine();
        
        System.out.println("Enter Account type: ");
        String accType= input.nextLine();
        
        System.out.println("Enter Balance: ");
        double balance = input.nextDouble();
        
        System.out.println("-----ACCOUNT SUMMARY-----");
        System.out.println("Account Holder: " + accHolder);   
        System.out.println("Account Number: " + accNumber); 
        System.out.println("Account Type: " + accType); 
        System.out.println("Balance: PHP" + balance); 
       input.close();
    }
}
