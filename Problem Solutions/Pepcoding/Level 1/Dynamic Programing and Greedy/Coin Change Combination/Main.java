import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int dp[] = new int[tar+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        System.out.print(coinChange(n,arr,tar,dp));
        scn.close();
    }
    
    public static int coinChange(int n, int arr[], int tar, int dp[])
    {
        int num;
        for(int i = 0; i<n; i++)
        {
            num = arr[i];
            for(int j = 1;j<=tar; j++)
            {
                if((j-num)<0)
                {
                    continue;
                }
                int ans = dp[j-num];
                dp[j] += ans;
            }
        }
        return dp[tar];
    }
}