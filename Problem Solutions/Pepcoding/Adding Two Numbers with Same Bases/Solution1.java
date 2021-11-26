import java.util.*;
  
  public class Solution1{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      System.out.print("Enter the Base of the Number : ");
      int b = scn.nextInt();
      System.out.print("Enter the First Number : ");
      int n1 = scn.nextInt();
      System.out.print("Enter the Second Number : ");
      int n2 = scn.nextInt();
      int d = getSum(b, n1, n2);
      System.out.println("The result is : "+d);
      scn.close();
    }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int carry = 0,temp1,temp2,ans = 0,mul = 1;
       while(n1>0 || n2>0)
       {
           temp1 = n1%10;
           temp2 = n2%10;
           ans += mul*((temp1 + temp2 + carry)%b);
           carry = (temp1 + temp2 + carry)/b;
           mul = mul*10;
           n1 = n1/10;
           n2 = n2/10;
       }
       if(carry!=0)
       {
           ans += carry*mul;
       }
       return ans;
   }
  }