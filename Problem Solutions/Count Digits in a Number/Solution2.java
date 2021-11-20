// Solution find the no. of digits in a given number using recursion.

import java.util.*;  
  public class Solution2{  
      
    public static int digitcount(int n)
    {
        if(n==0)  //Base case
        {
            return 0;
        }
        return (1+digitcount(n/10));
    }
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the number : ");
    int n = scn.nextInt(); 
    System.out.print("The number of digits in the number are : "+digitcount(n));
    scn.close(); // closing the Scanner object.
   }
}