import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.print(PaintFence(n,k));
        scn.close();
    }

    public static int PaintFence(int n, int k)
    {
        int dp[][] = new int[n+1][2];
        for(int i = 2; i <= n; i++)
        {
            if(i == 2)
            {
                dp[i][0] = k;
                dp[i][1] = k*(k-1);
            }
            else
            {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = (dp[i-1][0] + dp[i-1][1])*(k-1);
            }
        }
        return (dp[n][0] + dp[n][1]);
    }
}