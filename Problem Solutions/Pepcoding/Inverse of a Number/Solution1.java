/*
The inverse of a number is defined as the number created by interchanging the face value 
and index of digits of number.e.g. for 426135 (reading from right to left, 5 is in place 1,
 3 is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 and 4 is in place 6), 
 the inverse will be 416253 (reading from right to left, 3 is in place 1, 5 is in place 2,2
  is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6) More examples - 
  inverse of 2134 is 1243 and inverse of 24153 is 24153
*/

//Solution without using arrays.

import java.util.*;

public class Solution1{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        int ans = 0, temp, dig = 1;
        while (n > 0) {
            temp = n % 10;
            ans += dig * Math.pow(10, temp - 1);
            dig++;
            n /= 10;
        }
        System.out.print("The Inverse of the number is : "+ans);
        scn.close();
    }
}