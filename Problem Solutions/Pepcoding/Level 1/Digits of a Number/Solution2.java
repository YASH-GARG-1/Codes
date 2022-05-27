//Non-recursive Solution to Print the digits of a number.

import java.util.*;

public class Solution2 {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        int count = 0,num,mul;
        num = n;
        for(;num>0;num=num/10)//finding the no. of digits in the number.
        {
            count++;
        }
        count--;
        mul = (int)Math.pow(10,count);
        for(;count>=0;)  //Simply printing the digits of the number.
        {
            System.out.println(n/mul);
            n = n%mul;
            mul = mul/10;
            count--;
        }
        scn.close();
    }
}
