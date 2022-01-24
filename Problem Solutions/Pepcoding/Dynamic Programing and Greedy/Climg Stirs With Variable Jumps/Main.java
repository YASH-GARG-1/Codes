import java.io.*;
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
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        System.out.print(climbStairsT(n,arr,0,dp));
        scn.close();
    }
    
    public static int climbStairs(int n, int arr[], int idx)
    {
        if(idx == n)
        {
            return 1;
        }
        int sum=0;
        for(int i = 1;i<=arr[idx] && (idx+i)<=n; i++)
        {
            sum += climbStairs(n,arr,idx+i);
        }
        return sum;
    }

    public static int climbStairsM(int n, int arr[], int idx, int dp[])
    {
        if(idx == n)
        {
            return dp[idx] = 1;
        }
        if(dp[idx]!=0)
        {
            return dp[idx];
        }
        int sum=0;
        for(int i = 1;i<=arr[idx] && (idx+i)<=n; i++)
        {
            sum += climbStairs(n,arr,idx+i,dp);
        }
        return dp[idx] = sum;
    }

    public static int climbStairsT(int n, int arr[], int idx, int dp[])
    {
        for(int i = n; i >= 0; i--)
        {
            if(i == n)
            {
                dp[i] = 1;
            }
            else
            {
                int count = 0;
                for(int ele = 1; ele<=arr[i] && (i+ele)<= n; ele++)
                {
                    count += dp[i+ele];
                }
                dp[i] = count;
            }
        }
        return dp[idx];
    }
}