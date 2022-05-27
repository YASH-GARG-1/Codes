import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Value of N : ");
        int n = scn.nextInt();
        int spc = n - 4;
        int str = 1;
        System.out.println("The Pattern is : \n");
        if (n == 1) {
            System.out.print("*");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
            for (int i = 1; i < (n / 2); i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int k = 1; k <= spc; k++) {
                    System.out.print("\t");
                }
                spc -= 2;
                System.out.println("*");
            }
            for (int i = (n / 2 + 1); i >= 1; i--) {
                for (int j = 2; j <= i; j++) {
                    System.out.print("\t");
                }
                for (int k = 1; k <= str; k++) {
                    System.out.print("*\t");
                }
                str += 2;
                System.out.print("\n");
            }
        }
        scn.close();
    }
}