import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int lastInd = lastIndex(arr,0,x);
        System.out.print(lastInd);
        scn.close();
    }

    // public static int lastIndex(int[] arr, int idx, int x){
    //  //  ind = from the last.
    //     if(idx < 0)
    //     {
    //         return -1;
    //     }
    //     int eleind = -1;
    //     if(arr[idx] == x)
    //     {
    //         eleind = idx;
    //     }
    //     int maxind = lastIndex(arr,idx-1,x);
    //     if(maxind > eleind)
    //     {
    //         return maxind;
    //     }
    //     else
    //     {
    //         return eleind;
    //     }
    // }
    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length)
        {
            return -1;
        }
        int eleind = lastIndex(arr,idx+1,x);
        if(eleind > -1)
        {
            return eleind;
        }
        if(arr[idx] == x)
        {
            return idx;
        }
        return -1;
    }
}