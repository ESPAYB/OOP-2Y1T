

import java.util.Scanner;




        
        
        
public class TestForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        char decision; 
        do{
            System.out.println("Enter how many integers will u pick: ");
        int choice = input.nextInt();
        
        int arr[] = new int[choice];
        
        System.out.println("Enter elements: ");
        
        for (int i=0; i<choice; i++){
            arr[i] = input.nextInt();
        }
        
        for (int i=0; i<choice; i++){
            System.out.println((i+1) + ".) "+ arr[i]);
        }
            System.out.println("do you want to try again?: ");   
             decision = input.next().charAt(0);
            
        } while (decision == 'y' || decision =='Y');
        
         System.out.println("Thankyou for using the program^-^");
         
        input.close();
    }
}
