import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int dp[] = new int[n+1];
        System.out.print(TilingWithM_1T(n,m,dp));
        scn.close();
    }
    
    public static int TilingWithM_1(int n, int m,int dp[])
    {
        if(n == 0)
        {
            return dp[n] = 1;
        }
        if(dp[n] != 0)
        {
            return dp[n];
        }
        int count = 0;
        if((n-1)>=0)
        {
            int ans = TilingWithM_1(n-1,m,dp);
            count += ans;
        }
        if((n-m)>=0)
        {
            int ans = TilingWithM_1(n-m,m,dp);
            count += ans;
        }
        return dp[n] = count;
    }

    public static int TilingWithM_1T(int n, int m,int dp[])
    {
        for(int i = 0; i <= n; i++)
        {
            if(i <= 2)
            {
                dp[i] = 1;
                continue;
            }
            int ans1 = dp[i-1];
            int ans2 = 0;
            if((i-m)>=0)
            {
                ans2 = dp[i-m];
            }
            dp[i] = ans1+ans2;
        }
        return dp[n];
    }
}