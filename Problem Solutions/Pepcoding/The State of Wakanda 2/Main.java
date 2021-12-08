import java.util.*;

public class Main {

    public static void stateOfWakanda2(int arr[][], int n)
    {
        int num;
        for(int j = 0;j<n;j++)
        {
            num = j;
            for(int i = 0;i<n && num<n;i++)
            {
                System.out.println(arr[i][num]);
                num++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
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
        stateOfWakanda2(arr,n);
        scn.close();
    }

}