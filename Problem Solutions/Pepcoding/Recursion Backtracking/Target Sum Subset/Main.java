import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        printTargetSumSubsets(arr,0,"",0,tar);
        scn.close();
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos == tar)
        {
            for(int i = idx; i < arr.length; i++)
            {
                if((arr[i] + sos) == tar)
                {
                    printTargetSumSubsets(arr,i+1,set+arr[i]+", ",sos+arr[i],tar);
                }
            }
            System.out.println(set+".");
            return;
        }
        if((arr.length == idx) || (sos>tar))
        {
            return;
        }
        for(int i = idx; i < arr.length; i++)
        {
            if((arr[i] + sos) <= tar)
            {
                printTargetSumSubsets(arr,i+1,set+arr[i]+", ",sos+arr[i],tar);
            }
        }
    }

}