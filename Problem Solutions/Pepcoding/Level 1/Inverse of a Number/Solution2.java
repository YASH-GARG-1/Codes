//Solution implementation using arrays.

import java.util.*;

public class Solution2{

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        int num, len = 0, i = 1;
        num = n;
        while (n > 0) {
            len++;
            n = n / 10;
        }
        n = num;
        while (n > 0) {
            num = n % 10;
            arr[len - num] = i;
            i++;
            n = n / 10;
        }
        i = 0;
        System.out.print("The Inverse of the Number is : ");
        while (len > 0) {
            System.out.print(arr[i]);
            i++;
            len--;
        }
        scn.close();
    }
}