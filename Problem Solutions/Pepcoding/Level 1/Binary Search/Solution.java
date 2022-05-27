import java.util.*;

public class Solution
{
    public static int binarySearch(int arr[],int n,int ele)
    {
         int l,r,mid;
         l = 0;
         r = n-1;
         while(l<=r)
         {
             mid = l+(r-l)/2;
             if(arr[mid] == ele)
             {
                 return mid;
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
         return -1;
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Size of Array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Elements of Array : ");
        for(int i = 0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the Element you want to Search in Array : ");
        int ele = scn.nextInt();
        int ind = binarySearch(arr,n,ele);
        if(ind != -1)
        {
            System.out.print("Element is found at the index : "+ind);
        }
        else
        {
            System.out.print("Element is not present in array!!!");
        }
        scn.close();
	}
}
