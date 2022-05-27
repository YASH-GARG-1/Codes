//Implementing the Solution using the Arrays.
//Disadvantage : Uses Extra space.

import java.util.*;

public class Solution3{

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scn.nextInt();
        int arr[] = new int[12];
        int ind = -1;
        int temp;
        while (n > 0) {
            temp = n % 10;
            arr[++ind] = temp;
            n = n / 10;
        }
        System.out.println("The digits of the number are : ");
        while (ind >= 0) {
            System.out.println(arr[ind]);
            --ind;
        }
        scn.close();
    }
}