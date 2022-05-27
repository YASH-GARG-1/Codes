//from base 2 to base 10

import java.util.*;
  
  public class Solution1{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      System.out.print("Enter the value : ");
      int n = scn.nextInt();
      System.out.print("Enter the base of the Value : ");
      int b = scn.nextInt();
      int dn = getValueInDecimal(n, b);
      System.out.println("The value in Decimal is : "+dn);
      scn.close();
   }
  
   public static int getValueInDecimal(int n,int b){
       int mul = 1,temp,ans = 0;
       while(n>0)
       {
           temp = n%10;
           ans = ans + temp*mul;
           mul *= b;
           n = n/10;
       }
       return ans;
   }

}