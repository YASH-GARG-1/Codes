import java.util.*;

public class Solution{

public static void binarySearch(int arr[],int n,int ele)
{
    int l,r,mid;
    l = 0;
    r = n-1;
    while(l<=r)
    {
        mid = l + (r-l)/2;
        if(arr[mid] == ele)
        {
            System.out.print(ele);
            return;
        }
        else if(arr[mid] > ele)
        {
            r = mid-1;
        }
        else
        {
            l = mid+1;
        }
    }
    System.out.print(arr[l]+"\n"+arr[r]);
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0;i<n;i++)
    {
        arr[i] = scn.nextInt();
    }
    int ele = scn.nextInt();
    binarySearch(arr,n,ele);
    scn.close();
 }

}