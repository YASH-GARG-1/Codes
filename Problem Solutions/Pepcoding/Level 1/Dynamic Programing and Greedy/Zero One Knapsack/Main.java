import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int val[] = new int[n];
        for(int i  = 0; i < n; i++)
        {
            val[i] = scn.nextInt();
        }
        int wt[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        System.out.print(ZeroOneKnapsack(val,wt,cap));
        scn.close();
    }
    
    public static int ZeroOneKnapsack(int val[], int wt[], int cap)
    {
         int dp[][] = new int[val.length+1][cap+1];
         for(int i = 0; i < val.length+1; i++)
         {
             for(int j = 0; j < cap+1; j++)
             {
                 if(i == 0)
                 {
                     dp[i][j] = 0;
                 }
                 else if(j == 0)
                 {
                     dp[i][j] = 0;
                 }
                 else
                 {
                     int noCall = dp[i-1][j];
                     int yesCall = 0;
                     if((j-wt[i-1]) >= 0)
                     {
                         yesCall = val[i-1] + dp[i-1][j-wt[i-1]];
                     }
                     dp[i][j] = Math.max(noCall,yesCall);
                 }
             }
         }
        //  for(int i = 0; i < val.length+1; i++)
        //  {
        //      for(int j = 0; j < cap+1; j++)
        //      {
        //          System.out.print(dp[i][j] + " ");
        //      }
        //      System.out.print("");
        //  }
         return dp[val.length][cap];
    }
}