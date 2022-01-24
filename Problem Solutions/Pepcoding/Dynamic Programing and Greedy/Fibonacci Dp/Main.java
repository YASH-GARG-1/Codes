import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
    // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            arr[i] = -1;
        }
        // Arrays.fill(arr,-1);
        System.out.print(fibonaccisT(n,arr));
        scn.close();
    }
    
    public static int fibonaccis(int n){
        if(n <= 1)
        {
            return n;
        }
        return (fibonaccis(n-1)+fibonaccis(n-2));
    }

    public static int fibonaccisM(int n, int arr[]){
        if(n <= 1)
        {
            return arr[n] = n; // first store then return.
        }
        if(arr[n] != -1)
        {
            return arr[n];
        }
        arr[n] = fibonaccisM(n-1,arr)+fibonaccisM(n-2,arr);
        return arr[n];
    }

    public static int fibonaccisT(int n, int dp[]){
        for(int i = 0; i <= n; i++)
        {
            if(i <= 1)
            {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}