import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dp[i][j] = 0;
            }
        }
        System.out.print(minCostMazeTravelTabOpt(0,0,n-1,m-1,arr,arr[0][0],dp));
        scn.close();
    }
    
    // Recursive Solution.
    public static int minCostMazeTravel(int sr, int sc, int dr, int dc, int arr[][], int cost)
    {
        if(sr == dr && sc == dc)
        {
            return (cost+arr[sr][sc]);
        }
        int cost1 = -1,cost2 = -1;
        if(sc<dc)
        {
            cost1 = minCostMazeTravel(sr,sc+1,dr,dc,arr,cost + arr[sr][sc]);
        }
        if(sr<dr)
        {
            cost2 = minCostMazeTravel(sr+1,sc,dr,dc,arr,cost + arr[sr][sc]);
        }
        if(cost1 == -1)
        {
            return cost2;
        }
        else if(cost2 == -1)
        {
            return cost1;
        }
        else
        {
            if(cost2>cost1)
            {
                return cost1;
            }
            else
            {
                return cost2;
            }
        }
    }
    
    // DP with memoization.
    public static int minCostMazeTravelM(int sr, int sc, int dr, int dc, int arr[][], int cost, int dp[][])
    {
        if(sr == dr && sc == dc)
        {
            cost = cost+arr[sr][sc];
            return dp[sr][sc] = cost;
        }
        if(dp[sr][sc] != 0)
        {
            return dp[sr][sc];
        }
        int cost1 = -1,cost2 = -1;
        if(sc<dc)
        {
            cost1 = minCostMazeTravel(sr,sc+1,dr,dc,arr,cost + arr[sr][sc]);
        }
        if(sr<dr)
        {
            cost2 = minCostMazeTravel(sr+1,sc,dr,dc,arr,cost + arr[sr][sc]);
        }
        if(cost1 == -1)
        {
            return dp[sr][sc] = cost2;
        }
        else if(cost2 == -1)
        {
            return dp[sr][sc] = cost1;
        }
        else
        {
            if(cost2>cost1)
            {
                return dp[sr][sc] = cost1;
            }
            else
            {
                return dp[sr][sc] = cost2;
            }
        }
    }
    
    // Dp with Tabulation.
    public static int minCostMazeTravelT(int sr, int sc, int dr, int dc, int arr[][], int cost, int dp[][])
    {
        for(int i = dr; i >= 0; i--)
        {
            for(int j = dc; j >= 0; j--)
            {
                if(i == dr && j == dc)
                {
                    dp[dr][dc] = arr[dr][dc];
                    continue;
                }
                int cost1 = -1,cost2 = -1;
                if(j<dc)
                {
                    // cost1 = minCostMazeTravel(sr,sc+1,dr,dc,arr,cost + arr[sr][sc]);
                    cost1 = dp[i][j+1];
                }
                if(i<dr)
                {
                    // cost2 = minCostMazeTravel(sr+1,sc,dr,dc,arr,cost + arr[sr][sc]);
                    cost2 = dp[i+1][j];
                }
                if(cost1 == -1)
                {
                    dp[i][j] = cost2 + arr[i][j];
                }
                else if(cost2 == -1)
                {
                    dp[i][j] = cost1 + arr[i][j];
                }
                else
                {
                    if(cost2>cost1)
                    {
                        dp[i][j] = cost1 + arr[i][j];
                    }
                    else
                    {
                        dp[i][j] = cost2 + arr[i][j];
                    }
                }
            }
        }
        return dp[sr][sc];
    }

    public static int minCostMazeTravelTabOpt(int sr, int sc, int dr, int dc, int arr[][], int cost, int dp[][])
    {
        // Clean Code.
        for(int i = dr; i >= 0; i--)
        {
            for(int j = dc; j >= 0; j--)
            {
                if(i == dr && j == dc)
                {
                    dp[dr][dc] = arr[dr][dc];
                }
                else if(i == dr)
                {
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }
                else if(j == dc)
                {
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }
                else
                {
                    if(dp[i][j+1] < dp[i+1][j])
                    {
                        dp[i][j] = dp[i][j+1] + arr[i][j];
                    }
                    else
                    {
                        dp[i][j] = dp[i+1][j] + arr[i][j];
                    }
                }
            }
        }
        return dp[sr][sc];
    }
}