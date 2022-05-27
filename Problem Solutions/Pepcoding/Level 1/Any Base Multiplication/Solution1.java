import java.util.*;

public class Solution1{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the base of the numbers : ");
    int b = scn.nextInt();
    System.out.print("Enter the First Number : ");
    int n1 = scn.nextInt();
    System.out.print("Enter the Second Number : ");
    int n2 = scn.nextInt();
    int d = getProduct(b, n1, n2);
    System.out.println("The Product of Two Numbers is : "+d);
    scn.close();
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
     int ans = 0,mul = 1,temp,dup,temp2,carry = 0,finalmul = 1,finalans = 0,lastans=0;
     dup = n2;
     while(n1>0)
     {
         temp = n1%10;
         n2 = dup;
         mul = 1;
         carry = 0;
         ans = 0;
         while(n2>0)
        {
             temp2 = n2%10;
             ans += ((carry + (temp*temp2))%b)*mul;
             carry = (carry + (temp*temp2))/b;
             mul *= 10;
             n2 = n2/10;
        }
        if(carry!=0)
        {
            ans += ((carry)%b) * mul;
        }
        // finalans += ans;
        ans = ans*finalmul;
        finalmul *= 10;
        carry = 0;
        mul = 1;
        lastans = 0;
        while(ans>0 || finalans>0 || carry != 0)
        {
            temp = ans%10;
            temp2 = finalans%10;
            lastans += ((carry + temp + temp2)%b)*mul;
            carry = (carry + temp + temp2)/b;
            mul = mul*10;
            ans = ans/10;
            finalans = finalans/10;
        }
        finalans = lastans;
        n1 = n1/10;
     }
     return finalans;
 }

}