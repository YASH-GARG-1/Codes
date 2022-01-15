import java.util.*;

public class Main {

    public static void saddlePoint(int arr[][], int n)
    {
        int minIdxR,minIdxC,i,j;
        int count;
        for(int k = 0; k < n;k++)
        {
            minIdxR = j = k;
            for(i = 0; i < n; i++)
            {
                if(arr[minIdxR][j] < arr[i][j])
                {
                    minIdxR = i;
                }
            }
            minIdxC = j;
            count = 0;
            for(j = 0; j < n; j++)
            {
                if(arr[minIdxR][minIdxC] > arr[minIdxR][j])
                {
                    count = 1;
                    break;
                }
            }
            if(count == 0)
            {
                System.out.print(arr[minIdxR][minIdxC]);
                return;
            }
        }       
        System.out.print("Invalid input");
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        saddlePoint(arr,n);
        scn.close();
    }
}