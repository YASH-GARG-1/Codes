class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return UniquePathsDp(0,0,m-1,n-1,dp);
    }
    
    public int UniquePaths(int sr, int sc, int dr, int dc)
    {
        if((sr == dr)&&(sc == dc))
        {
            return 1;
        }
        int count = 0;
        if(sc<dc)
        {
            int ans = UniquePaths(sr,sc+1,dr,dc);
            count += ans;
        }
        if(sr<dr)
        {
            int ans = UniquePaths(sr+1,sc,dr,dc);
            count += ans;
        }
        return count;
    }
    
    public int UniquePathsDp(int sr, int sc, int dr, int dc, int dp[][])
    {
        int n = dp.length-1;
        int m = dp[0].length-1;
        for(int i = n; i >= 0; i--)
        {
            for(int j = m; j >= 0; j--)
            {
                if((j == m)||(i == n))
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}