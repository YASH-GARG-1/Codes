import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Value of N : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : \n");
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
        scn.close();
    }
}