import java.util.*;

public class Main {
    
    public static void searchIn2D(int arr[][],int n,int x)
    {
        int i = 0;
        int j = n-1;
        while(j>=0 && i<n)
        {
            if(arr[i][j] == x)
            {
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(arr[i][j] < x)
            {
                i++;
            }
            else
                j--;
        }
        System.out.print("Not Found");
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
        int x = scn.nextInt();
        searchIn2D(arr,n,x);
        scn.close();
    }

}