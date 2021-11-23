//Solution for printing the digits of a number in reverse order without using Recursion.
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scn.nextInt();
        // We can simply solve this problem by finding the last digit of the number by doing number%10
        // and after finding the last digit, we will simply divide the number by 10 so that we find the
        // second last digit and the process continues till the number is greater than 0.
        for(;n>0;n=n/10)
        {
            System.out.println(n%10);
        }
        scn.close();
    }
}
