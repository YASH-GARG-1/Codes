import java.util.*;
  //Simple SOlution to print all the Fibonacci numbers till N.
  public class Solution1{
  public static void main(String[] args) {
      // write your code here
      Scanner scn = new Scanner(System.in);
      System.out.print("Enter the value of N : ");
      int n = scn.nextInt();
      System.out.print("The Fabonacci numbers till N are : ");
      int a = 0,b=1,c;
      // Running time of this solution : O(n).
      for(int i = 0;i<n;i++)
      {
          System.out.print(a+" ");
          c = a+b;
          a = b;
          b = c;
      }
      scn.close();
   }
}