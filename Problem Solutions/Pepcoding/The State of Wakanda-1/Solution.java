import java.util.*;

public class Solution{

public static void stateOfWakanda(int arr[][],int n,int m)
{
    System.out.println("the Path Travelled by the visitor is : ");
    for(int i = 0; i<m;i++)
    {
        if(i%2==0)
        {
            for(int j= 0;j<n;j++)
            {
                System.out.println(arr[j][i]);
            }
        }
        else
        {
            for(int j = n-1;j>=0;j--)
            {
                System.out.println(arr[j][i]);
            }
        }
    }
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the rows of Array : ");
    int n = scn.nextInt();
    System.out.print("Enter the Columns in Array : ");
    int m = scn.nextInt();
    int arr[][] = new int[n][m];
    System.out.println("Enter the Elements of Array : ");
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            arr[i][j] = scn.nextInt();
        }
    }
    stateOfWakanda(arr,n,m);
    scn.close();
 }

}