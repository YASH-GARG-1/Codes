import java.util.*;

public class Solution1 {

    public static int findElement(int arr[], int n, int ele) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Size of Array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements of Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the Element you want to find in Array : ");
        int ele = scn.nextInt();
        int ind = findElement(arr, n, ele);
        if(ind == -1)
        {
            System.out.print("The Element is Not present in array.");
        }
        else
        {
            System.out.print("Element is Present at the index : "+ind);
        }
        scn.close();
    }

}