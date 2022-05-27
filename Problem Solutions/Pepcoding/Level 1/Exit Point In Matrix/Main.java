import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int i=0,j=0;
        int a[][] = new int[n][m];
        for(i = 0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                a[i][j] = scn.nextInt();
            }
        }
        i=0;
        j=0;
        while(true)
        {
            for(;j<m;j++)
            {
                if(a[i][j]==1)
                {
                    i+=1;
                    break;
                }
            }
            if(j==m)
            {
                System.out.println(i);
                System.out.print(j-1);
                break;
            }
            for(;i<n;i++)
            {
                if(a[i][j]==1)
                {
                    j-=1;
                    break;
                }
            }
            if(i==n)
            {
                System.out.println(i-1);
                System.out.print(j);
                break;
            }
            for(;j>=0;j--)
            {
                if(a[i][j]==1)
                {
                    i-=1;
                    break;
                }
            }
            if(j==-1)
            {
                System.out.println(i);
                System.out.print(j+1);
                break;
            }
            for(;i>=0;i--)
            {
                if(a[i][j]==1)
                {
                    j+=1;
                    break;
                }
            }
            if(i==-1)
            {
                System.out.println(i+1);
                System.out.print(j);
                break;
            }
        }
        scn.close();
    }

}