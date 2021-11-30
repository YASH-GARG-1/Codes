import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        int max = -1;
        System.out.print("Enter the Elements of Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("The Pattern of Bar Chart is : \n");
        for (int i = max; i >= 1; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
        scn.close();
    }

}