import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt();
        int dp[] = new int[n+1];
        System.out.print(TilingT(n,dp));
        scn.close();
    }

    public static int TilingT(int n,int dp[])
    {
        if(n == 1)
        {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int Tiling(int n,int dp[])
    {
        if(n == 0)
        {
            return 1;
        }
        if(dp[n] != 0)
        {
            return dp[n];
        }
        int count = 0;
        if((n-1)>=0)
        {
            int ans = Tiling(n-1,dp);
            count += ans;
        }
        if((n-2)>=0)
        {
            int ans = Tiling(n-2,dp);
            count += ans;
        }
        return dp[n] = count;
    }
}