import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        // System.out.print("Enter the Size of Array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        // System.out.print("Enter the Elements of Array : ");
        for(int i = 0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        // System.out.print("Enter the Element you want to find the Index of :");
        int x = scn.nextInt();
        int firstInd = firstIndex(arr,0,x);
        // System.out.print("The first Index of the ELememts is : ");
        System.out.print(firstInd);
        scn.close();
    }

    // public static int firstIndex(int[] arr, int idx, int x){
    
    // // ind = from the last.
    //     if(idx < 0)
    //     {
    //         return -1;
    //     }
    //     int eleind = -1;
    //     if(x == arr[idx])
    //     {
    //         eleind = idx;
    //     }
    //     int minind = firstIndex(arr,idx-1,x);
    //     if(minind == -1)
    //     {
    //         return eleind;
    //     }
    //     else if(eleind == -1)
    //     {
    //         return minind;
    //     }
    //     else
    //     {
    //         if(minind < eleind)
    //         {
    //             return minind;
    //         }
    //         else
    //         {
    //             return eleind;
    //         }
    //     }
    // }

    public static int firstIndex(int[] arr, int idx, int x){
        
        if(idx == arr.length)
        {
            return -1;
        }
        if(arr[idx] == x)
        {
            return idx;
        }

        return firstIndex(arr,idx+1,x);
    }

}