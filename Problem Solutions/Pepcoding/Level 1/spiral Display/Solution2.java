import java.util.*;

public class Solution2{

    public static void spiralDisplay(int arr[][],int n,int m)
    {
        int minr,maxr,minc,maxc;
        minr = minc = 0;
        maxr = n-1;
        maxc = m-1;
        System.out.println("The Spiral Traversal is : ");
        while(true)
        {
            if(minr>maxr || minc>maxc)
            {
                break;
            }
            for(int i = minr;i<=maxr; i++)
            {
                System.out.println(arr[i][minc]);
            }
            minc++;
            if(minr>maxr || minc>maxc)
            {
                break;
            }
            for(int i = minc;i<=maxc; i++)
            {
                System.out.println(arr[maxr][i]);
            }
            maxr--;
            if(minr>maxr || minc>maxc)
            {
                break;
            }
            for(int i = maxr;i>=minr; i--)
            {
                System.out.println(arr[i][maxc]);
            }
            maxc--;
            if(minr>maxr || minc>maxc)
            {
                break;
            }
            for(int i = maxc;i>=minc; i--)
            {
                System.out.println(arr[minr][i]);
            }
            minr++;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows in Array : ");
        int n = scn.nextInt();
        System.out.print("Enter the number of columns in Array : ");
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter the Elements of array : ");
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        spiralDisplay(arr,n,m);
        scn.close();
    }

}