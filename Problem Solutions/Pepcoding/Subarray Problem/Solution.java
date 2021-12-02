import java.util.*;

public class Solution{

public static void printingSubarray(int n,int arr[])
{
    int num = 0;
    while(num<n)
    {
        for(int i = num;i<n;i++)
        {
            for(int j = num; j<=i;j++)
            {
                System.out.print(arr[j]+"\t");
            }
            System.out.print("\n");
        }
        num++;
    }
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
    printingSubarray(n,arr);
    scn.close();
 }

}