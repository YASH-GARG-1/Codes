import java.util.*;

public class Solution2{

    public static void exitPointOfMatrix(int arr[][], int n, int m)
    {
        int i,j,sum,rem;
        i = 0;
        j = 0;
        sum = 0;
        while(i<n && i>=0 && j<m && j>=0)
        {
            sum += arr[i][j];
            rem = sum%4;
            if(rem == 0)
                j++;
            else if(rem == 1)
                i++;
            else if(rem == 2)
                j--;
            else
                i--;
        }
        if(i<0)
            i++;
        else if(i>=n)
            i--;
        else if(j<0)
            j++;
        else if(j>=m)
            j--;
        System.out.print(i+"\n"+j);
    }

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
        exitPointOfMatrix(arr,n,m);
        scn.close();
    }

}