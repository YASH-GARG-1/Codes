//Simple Recursive solution to print the digits of a number.
import java.util.*;

public class Solution1 {

    public static void PrintDigits(int n) {
        // Made the function as sttic so that I don't have to make the object of the class
        // to access the function.
        if (n == 0) { //Base case of the function.
            return;
        }
        PrintDigits(n / 10);
        System.out.println(n % 10);
        //reverse the lines 12 and 13 if you want to print the digits of a number in a reverse order. 
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        System.out.println("The Digits of the Number are : ");
        PrintDigits(n);
        scn.close();
    }
}