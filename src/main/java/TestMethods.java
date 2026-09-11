
import java.util.Scanner;

public class TestMethods {
    
    static public int Add(int add1, int add2){
    return add1 +add2;
}
    static public int subtract(int sub1, int sub2){
        return sub1 - sub2;
    }
    static public void display(){
        System.out.println("What operation do u want: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.print("Enter:");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Enter number 1: ");
        int num1 = input.nextInt();
        
        System.out.println("Enter number 1: ");
        int num2 = input.nextInt();
        
        display();
        
        int choice = input.nextInt();
        System.out.println("");
        switch(choice){
            case 1:  int addResult = Add(num1, num2);
                     System.out.println("result: "+ addResult);
                     break;
            case 2: int subResult = subtract(num1, num2);         
                    System.out.println("result: "+ subResult);
                    break;
                    
            default: System.out.println("Invalid!!!");
                     break;
        }
       
        
        input.close();
    }
}
