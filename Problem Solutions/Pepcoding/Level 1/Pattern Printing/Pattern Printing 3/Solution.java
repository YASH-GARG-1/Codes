import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Value of N : ");
        int n = scn.nextInt();
        System.out.println("The patter is : \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("\t");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
        scn.close();
    }
}