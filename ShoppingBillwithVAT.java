/*
 Gene Andrei B. HIlario TA21
 */
package com.mycompany.java1st;

import java.util.Scanner;


public class ShoppingBillwithVAT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Enter Product Price: ");
        double productPrice = input.nextDouble();
        
        System.out.println("Enter how many: ");
        int quantity = input.nextInt();
        
        double vat =  quantity * productPrice * 0.12;
        
        double subtotal = productPrice * quantity;
        
        double total = subtotal + vat;
        
        System.out.println("Subtotal: "+ subtotal);
        System.out.println("VAT: "+ vat);
        System.out.println("total: " + total);
        
        input.close();
    }
}
