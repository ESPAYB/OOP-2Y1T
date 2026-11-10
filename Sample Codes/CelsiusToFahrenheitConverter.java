/*
 Gene Andrei B. HIlario TA21
 */
package com.mycompany;

import java.util.Scanner;

public class CelsiusToFahrenheitConverter {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         
         System.out.println("Enter Celsius Temperature: ");
         double celsius = input.nextDouble();
         
         double fahrenheit = celsius*9 / 5 + 32;
         
         System.out.println("fahrenheit convertion: " + fahrenheit);
         
         input.close();
    }
}
