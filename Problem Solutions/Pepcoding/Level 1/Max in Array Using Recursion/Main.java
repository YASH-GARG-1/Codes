import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of array :");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements of Array : ");
        for(int i = 0; i<n;i++)
        {
            arr[i] = scn.nextInt();
        }
        int maxele = maxOfArray(arr,n-1);
        System.out.print("The Max. Element in the Array is : " + maxele);
        scn.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        
        if(idx == 0)
        {
            return arr[idx];
        }
        int maxele = maxOfArray(arr,idx-1);
        int ele = arr[idx];
        if(maxele > ele)
        {
            return maxele;
        }
        else
        {
            return ele;
        }
    }

}