/*
 Gene Andrei B. HIlario TA21
 */

import java.util.Scanner;


public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Enter hours worked: ");
        double hours = input.nextDouble();
        
        System.out.println("Enter hourly rate: ");
        double hourlyRate = input.nextDouble();
        
        double grossSalary = hours * hourlyRate;
        
        System.out.println("Gross salary: PHP " + grossSalary);
        
        input.close();
    }
}
