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
        System.out.print(goldmineSol(n,m,arr));
        scn.close();
    }
    
    public static int goldmineSol(int n, int m, int arr[][])
    {
        int sum = 0;
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            int num = goldCall(i,0,arr,0,n,m,dp);
            if(num>sum)
            {
                sum = num;
            }
        }
        return sum;
    }
    
    public static int goldCall(int row, int col, int arr[][], int sum, int n, int m,int dp[][])
    {
        if(row < 0 || row == n || col >= m)
        {
            return 0;
        }
        if(col == (m-1))
        {
            return sum+arr[row][col];
        }
        int max = 0,num1=0,num2=0,num3=0;
        num1 = goldCall(row-1,col+1,arr,sum+arr[row][col],n,m);
        num2 = goldCall(row,col+1,arr,sum+arr[row][col],n,m);
        num3 = goldCall(row+1,col+1,arr,sum+arr[row][col],n,m);
        max = Math.max(num1,Math.max(num2,num3));
        return max;
    }
}