import java.util.*;

public class Solution{

public static void firstAndLastIndex(int arr[],int n,int ele)
{
    int l,r,mid;
    l = 0;
    r = n-1;
    int fi = -1,li = -1;
    while(l<=r)
    {
        mid = l+(r-l)/2;
        if(arr[mid] == ele)
        {
            fi = mid;
            r = mid - 1;
        }
        else if(arr[mid] > ele)
        {
            r = mid-1;
        }
        else
        {
            l = mid + 1;
        }
    }
    l = fi;
    r = n-1;
    while(l<=r)
    {
        mid = l + (r-l)/2;
        if(arr[mid] == ele)
        {
            li = mid;
            l = mid + 1;
        }
        else if(arr[mid] > ele)
        {
            r = mid-1;
        }
        else
        {
            l = mid + 1;
        }
    }
    if(fi == -1)
    {
        System.out.print("Element Is not Present In Array!!!");
        return;
    }
    System.out.print("First Index of The Element : "+fi + ", Last Index of the Element : " + li);
}

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the Size of Array : ");
    int n = scn.nextInt();
    int arr[] = new int[n];
    System.out.print("Enter the Elements of Array : ");
    for(int i = 0;i<n;i++)
    {
        arr[i] = scn.nextInt();
    }
    System.out.print("Enter the Element you want to find its first index and last Index : ");
    int ele = scn.nextInt();
    firstAndLastIndex(arr,n,ele);
    scn.close();
 }

}