// Solution find the no. of digits in a given number.

import java.util.*;  
  public class Solution1{  
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the number : ");
    int n = scn.nextInt(); 
    System.out.print("The number of digits in the number are : ");
    int count = 0; //variable to count the no. of digits in a variable.
    for(; n>0 ;n = n/10)
    {
        //Applying the simple method of finding how many times a number is divisible by 10, which
        //simply gives the the number of digits present in a number.
        count++;
    }
    System.out.println(count);
    scn.close(); // closing the Scanner object.
   }
}