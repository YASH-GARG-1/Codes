import java.util.*;

public class Solution1{

public static int spanOfArray(int [] arr,int n)
{
    int min = arr[0];
    int max = arr[0];
    int span;
    for(int i = 1;i<n;i++)
    {
        // System.out.print(arr[i] + " ");
        if(arr[i] < min)
        {
            min = arr[i];
        }
        if(arr[i] > max)
        {
            max = arr[i];
        }
    }
    span = max - min;
    return span;
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the Size of Array : ");
    int n = scn.nextInt();
    int arr[] = new int[n];
    System.out.print("Enter the Elements of Array : ");
    for(int i = 0;i<n;i++)
    {
        arr[i] = scn.nextInt();
    }
    int ans = spanOfArray(arr,n);
    System.out.print("The Span of the Array (Max_ele - Min_ele) is : "+ans);
    scn.close();
 }

}