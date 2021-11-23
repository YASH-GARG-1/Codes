//Solution to check whether the number is palindrome or not using arrays.

import java.util.*;

public class Solution2 {
    public static boolean isPalindrome(int x) {
        boolean flag;
        if (x < 0) // If the number is negative then it is not Palindrome.
        {
            return false;
        }
        int arr[] = new int[12];
        int ind = -1,arr_len;
        while(x>0)
        {
            arr[++ind] = x%10;
            x = x/10;
        }
        arr_len = ind+1;
        flag = true; 
        for(int i = 0;i<(arr_len/2);i++) //checking the first and last digit then second and 
        {                                //second last digit and so on.
            if(arr[i]!=arr[arr_len-i-1])
            {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        if (isPalindrome(n)) {
            System.out.println("The number is Palindrome!!!");
        } else {
            System.out.println("The number is not a Palindrome!!!");
        }
        scn.close();
    }
}