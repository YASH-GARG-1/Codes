//Simple Solution to check whether the number is palindrome or not.

import java.util.*;

class Solution1{
    public static boolean isPalindrome(int x) {
        if(x<0) //If the number is negative then it is not Palindrome.
        {
            return false;
        }
        int temp = x,num=0;
        while(temp>0) //Finding the reverse of the number. Ex : 1234 recverse is 4321.
        {
            num = num*10 + temp%10;
            temp = temp/10;
        }
        if(num == x) // Checking whether the reverse of the number is same or not as Palindrome
        {            // numbers reverse is same as the number.
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        if(isPalindrome(n))
        {
            System.out.println("The number is Palindrome!!!");
        }
        else
        {
            System.out.println("The number is not a Palindrome!!!");
        }
        scn.close();
    }
}