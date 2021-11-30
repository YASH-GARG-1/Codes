import java.util.*;

public class Solution {

    public static int addTwoArrays(int arr[], int arr2[], int arr3[], int n, int m, int arr_size) {

        int carry = 0, ind = -1, i = n - 1, j = m - 1;
        while (i != -1 && j != -1) {
            arr3[++ind] = (carry + arr[i] + arr2[j]) % 10;
            carry = (carry + arr[i] + arr2[j]) / 10;
            i--;
            j--;
        }
        if (i != -1) {
            while (i != -1) {
                arr3[++ind] = (carry + arr[i]) % 10;
                carry = (carry + arr[i]) / 10;
                i--;
            }
        }
        if (j != -1) {
            while (j != -1) {
                arr3[++ind] = (carry + arr2[j]) % 10;
                carry = (carry + arr2[j]) / 10;
                j--;
            }
        }
        if (carry != 0) {
            arr3[++ind] = carry;
        }
        reverseArray(arr3, ind);
        return ind;
    }

    public static void reverseArray(int arr[], int n) {
        int temp;
        for (int i = 0; i < (n + 1) / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = temp;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int arr_size;
        System.out.print("Enter the Size of array 1 : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements of array 1 : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the Size of array 2 : ");
        int m = scn.nextInt();
        int arr2[] = new int[m];
        System.out.print("Enter the Elements of array 2 : ");
        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        if (n > m) {
            arr_size = n + 1;
        } else {
            arr_size = m + 1;
        }
        int arr3[] = new int[arr_size];
        int ind = addTwoArrays(arr, arr2, arr3, n, m, arr_size);
        System.out.print("The Sum of Two arrays is : ");
        for (int i = 0; i <= ind; i++) {
            System.out.print(arr3[i] + " ");
        }
        scn.close();
    }

}