import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
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
        System.out.print(paintHouseManyColors(n,m,arr));
        scn.close();
    }
    
    public static int paintHouseManyColors(int houses, int paints, int arr[][])
    {
        int dp[][] = new int[houses][paints];
        for(int i = 0; i < houses; i++)
        {
            for(int j = 0; j < paints; j++)
            {
                if(i == 0)
                {
                    dp[i][j] = arr[i][j];
                }
                else
                {
                    int min_ele = Integer.MAX_VALUE;
                    for(int k = 0; k < paints; k++)
                    {
                        if(k == j)
                        {
                            continue;
                        }
                        min_ele = Math.min(min_ele,dp[i-1][k]);
                    }
                    dp[i][j] = arr[i][j] + min_ele;
                }
            }
        }
        // for(int i = 0; i < houses; i++)
        // {
        //     for(int j = 0; j < paints; j++)
        //     {   
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
        int min_ele = Integer.MAX_VALUE;
        for(int k = 0; k < paints; k++)
        {
            min_ele = Math.min(min_ele,dp[houses-1][k]);
        }
        return min_ele;
    }
}