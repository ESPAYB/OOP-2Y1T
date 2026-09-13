/*
 Gene Andrei B. HIlario TA21
 */
package com.mycompany.java1st;

import java.util.Scanner;


public class OnlineGamePlayer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Username: ");
        String username = input.nextLine();
        
        System.out.println("Enter Character Name: ");
        String charName = input.nextLine();
        
        System.out.println("Enter Level: ");
        int level = input.nextInt();
        
        System.out.println("Enter Exp points: ");
        long expPoints = input.nextLong();
        input.nextLine();         //input buffer
        
        System.out.println("Enter Rank: ");
        String rank = input.nextLine();
        
         System.out.println("-----GAME ACCOUNT SUMMARY------");
        System.out.println("Username: " +username);
        System.out.println("Character Name: " + charName);
        System.out.println("Level: "+ level);
        System.out.println("Exp points: " +expPoints);
        System.out.println("Rank: "+ rank );
         
        input.close();
    }
}
