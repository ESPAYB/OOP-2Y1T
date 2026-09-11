/*
 Gene Andrei B. HIlario TA21
 */

import java.util.Scanner;

public class CourseEnrollment {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         
         System.out.println("Enter Student Name: ");
         String studentName = input.nextLine();
         
         System.out.println("Enter Subject Code: ");
         String subjectCode = input.nextLine();
         
         System.out.println("Enter Subject Title: ");
         String subjectTitle = input.nextLine();
         
         System.out.println("Enter Units: ");
         int units = input.nextInt();
         
         System.out.println("Enter Section Letter: ");
         char sectionLetter = input.next().charAt(0);
         
         System.out.println("-----COURSE ENROLLMENT SUMMARY------");
         System.out.println("Student Name: " + studentName);
         System.out.println("Subject Code: " + subjectCode);
         System.out.println("Subject Title: " + subjectTitle) ;
         System.out.println("Units: " + units);
         System.out.println("Section Letter: "+ sectionLetter);
         
         input.close();
    }
}
