import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : \n");
        if (n == 1) {
            System.out.print("*");
        } else {
            for (int i = 1; i <= (n / 2); i++) {
                for (int j = 1; j <= (n / 2); j++) {
                    System.out.print("\t");
                }
                for (int k = 1; k <= i; k++) {
                    System.out.print("*\t");
                }
                System.out.print("\n");
            }
            for (int i = 1; i <= n; i++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
            for (int i = n / 2; i >= 1; i--) {
                for (int j = 1; j <= (n / 2); j++) {
                    System.out.print("\t");
                }
                for (int k = 1; k <= i; k++) {
                    System.out.print("*\t");
                }
                System.out.print("\n");
            }
        }
        scn.close();
    }
}