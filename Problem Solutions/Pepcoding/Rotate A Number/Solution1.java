import java.util.*;
   
   public class Solution1{
   
   public static int digitCount(int num)
   {
       int count = 0;
       while(num>0)
       {
           count++;
           num = num/10;
       }
       return count;
   }
   
   public static int TenMul(int mul,int r)
   {
        int ans = 1;
        while(r>0)
        {
            ans = ans*mul;
            r--;
        }
        return ans;    
   }

   public static int rotateNum(int num,int r)
   {
       int len;
       len = digitCount(num);
       r = (r%len + len)%len;
       int a = num/TenMul(10,r);
       int b = num%TenMul(10,r);
       return (b*TenMul(10,len-r) + a);
   }
   
   public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     System.out.print("Enter the Number : ");
     int n = scn.nextInt();
     System.out.print("Enter the value of K : ");
     int k = scn.nextInt();
     System.out.print("The Number after Rotation is : ");
     System.out.print(rotateNum(n,k));
     scn.close();
    }
   }