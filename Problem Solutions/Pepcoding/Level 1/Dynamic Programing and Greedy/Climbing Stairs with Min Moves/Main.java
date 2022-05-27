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
        int ans = climbStairsMinMovesT(0,n,arr,0,dp);
        if(ans == (n+1))
        {
            System.out.print("null");
        }
        else
        {
            System.out.print(ans);
        }
        scn.close();
    }
    
    // Solving the Problem Using Recursion.
    public static int climbStairsMinMoves(int idx, int n, int arr[],int jumps)
    {
        if(idx>n)
        {
            return n+1;
        }
        if(idx == n)
        {
            return jumps;
        }
        int min = n+1;
        for(int i = 1;i<=arr[idx] && (i+idx)<=n; i++)
        {
            int ans = climbStairsMinMoves(idx+i,n,arr,jumps+1);
            if(min>ans)
            {
                min = ans;
            }
        }
        return min;
    }

    // Solving the Problem Using Memoization
    public static int climbStairsMinMovesM(int idx, int n, int arr[],int jumps,int dp[])
    {
        if(idx == n)
        {
            return dp[idx] = jumps;
        }
        if(dp[idx] != 0)
        {
            return dp[idx];
        }
        int min = n+1;
        for(int i = 1;i<=arr[idx] && (i+idx)<=n; i++)
        {
            int ans = climbStairsMinMoves(idx+i,n,arr,jumps+1);
            if(min>ans)
            {
                min = ans;
            }
        }
        return dp[idx] = min;
    }

    // Solving the Problem Using Tabulation Method.
    public static int climbStairsMinMovesT(int idx, int n, int arr[],int jumps,int dp[])
    {
        for(int j = n; j>=0; j--)
        {
            if(j == n)
            {
                dp[j] = 1;
                continue;
            }
            else if(arr[j] == 0)
            {
                dp[j] = n+2;
                continue;
            }
            int min = n+2;
            for(int i = 1;i<=arr[j] && (i+j)<=n; i++)
            {
                int ans = dp[i+j];
                if(ans == (n+2))
                {
                    continue;
                }
                ans += 1;
                if(min>ans)
                {
                    min = ans;
                }
            }
            dp[j] = min;
        }
        return dp[idx]-1;
    }
}