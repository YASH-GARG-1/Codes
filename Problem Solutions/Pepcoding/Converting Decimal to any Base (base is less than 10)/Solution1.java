import java.util.*;
  
  public class Solution1{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      System.out.print("Enter the number (in base 10 ) : ");
      int n = scn.nextInt();
      System.out.print("Enter the base you want to convert it into (base <= 10): ");
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println("The Ans is : " + dn);
      scn.close();
    }
  
   public static int getValueInBase(int n, int b){
       int temp,ans = 0,mul = 1;
       while(n>0)
       {
           temp = n%b;
           ans = ans + temp*mul;
           mul *= 10;
           n = n/b;
       }
       return ans;
   }
  }