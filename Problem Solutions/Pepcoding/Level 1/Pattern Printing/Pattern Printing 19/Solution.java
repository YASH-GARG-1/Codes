import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : \n");
        if (n == 1) {
            System.out.print("*");
        } else {
            for (int i = 1; i <= (n / 2 + 1); i++) {
                System.out.print("*\t");
            }
            for (int i = 1; i < (n / 2); i++) {
                System.out.print("\t");
            }
            System.out.println("*");
            for (int i = 1; i < (n / 2); i++) {
                for (int j = 1; j <= (n / 2); j++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int k = 1; k < (n / 2); k++) {
                    System.out.print("\t");
                }
                System.out.println("*");
            }
            for (int i = 1; i <= n; i++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
            for (int i = 1; i < (n / 2); i++) {
                System.out.print("*\t");
                for (int k = 1; k < (n / 2); k++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int j = 1; j <= (n / 2); j++) {
                    System.out.print("\t");
                }
                System.out.print("\n");
            }
            System.out.print("*\t");
            for (int i = 1; i < (n / 2); i++) {
                System.out.print("\t");
            }
            for (int i = 1; i <= (n / 2 + 1); i++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
        scn.close();
    }
}