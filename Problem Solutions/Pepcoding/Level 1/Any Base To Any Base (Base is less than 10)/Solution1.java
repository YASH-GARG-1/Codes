import java.util.*;
  
  public class Solution1{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      System.out.print("Enter the Value : ");
      int n = scn.nextInt();
      System.out.print("Enter the Source Base : ");
      int sourceBase = scn.nextInt();
      System.out.print("Enter the Destination Base : ");
      int  destBase= scn.nextInt();
      int ans = getValueInDecimal(n,sourceBase,destBase);
      System.out.print("The Ans is : "+ans);
        scn.close();
   }  
  
  public static int getValueInDecimal(int n,int b,int d){
       int mul = 1,temp,ans = 0;
       while(n>0)
       {
           temp = n%10;
           ans = ans + temp*mul;
           mul *= b;
           n = n/10;
       }
       return getValueInBase(ans,d);
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