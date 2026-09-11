/*
 Gene Andrei B. HIlario TA21
 */

import java.util.Scanner;

public class MovieInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter Movie Title: ");
        String movieTitle = scanner.nextLine();
        
        System.out.println("Enter Director: ");
        String director = scanner.nextLine();
        
        System.out.println("Enter Release Year: ");
        int releaseYear = scanner.nextInt();
        
        System.out.println("Enter Run time in minutes: ");
        int runTime = scanner.nextInt();
        
        System.out.println("Enter Rating: ");
        double rating = scanner.nextDouble();
        
        System.out.println("-----MOVIE SUMMARY------");
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Director: " + director);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Runtime in minutes: " + runTime);
        System.out.println("Rating: " + rating);
        
        scanner.close();
    }
}
