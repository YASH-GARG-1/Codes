import java.util.*;

public class Main {

    public static void display(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbingStairsT(n,dp));
        // display(dp);
        scn.close();
    }
    
    public static int climbingStairs(int n)
    {
        if(n == 0)
        {
            return 1;
        }
        int count = 0;
        if((n-1)>=0)
        {
            count += climbingStairs(n-1); 
        }
        if((n-2)>=0)
        {
            count += climbingStairs(n-2); 
        }
        if((n-3)>=0)
        {
            count += climbingStairs(n-3); 
        }
        return count;
    }

    public static int climbingStairsM(int n, int dp[])
    {
        if(n == 0)
        {
            return dp[n] = 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int count = 0;
        if((n-1)>=0)
        {
            count += climbingStairs(n-1,dp); 
        }
        if((n-2)>=0)
        {
            count += climbingStairs(n-2,dp); 
        }
        if((n-3)>=0)
        {
            count += climbingStairs(n-3,dp); 
        }
        return dp[n] = count;
    }

    public static int climbingStairsT(int N, int dp[])
    {
        for(int n = 0; n < dp.length; n++)
        {
            if(n == 0)
            {
                dp[n] = 1;
                continue;
            }
            int count = 0;
            if((n-1)>=0)
            {
                count += dp[n-1]; 
            }
            if((n-2)>=0)
            {
                count += dp[n-2]; 
            }
            if((n-3)>=0)
            {
                count += dp[n-3]; 
            }
            dp[n] = count;
        }
        return dp[N];
    }
}