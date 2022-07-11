import java.util.*;

public class MazePathsWithJumps
{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
        int dirA[][] = {{1,0},{1,1},{0,1}};
		System.out.print("No. of paths are : " + findMazePaths(n,m,0,0));
        System.out.print("\nNo. of paths using Direction array are : " + findPathsUsingDirArr(n,m,0,0,dirA));
        String [] dirS = {"V", "D", "H"};
        System.out.print("\nNo. of paths using Direction array are : ");
        findPaths(n,m,0,0,"",dirS);
        System.out.print("\nNo. of paths using Direction array are : ");
        findPathsWithJumps(n,m,0,0,"",dirS);
	}
	
	public static int findMazePaths(int n, int m, int i, int j)
	{
	    if((i >=n) || (j >= m))
		{
			return 0;
		}
		if((i == n-1) && (j == m-1))
		{
			return 1;
		}
		return (findMazePaths(n, m, i+1, j) + findMazePaths(n, m, i+1, j+1) + findMazePaths(n, m, i, j+1));	
	}
	
	public static int findPathsUsingDirArr(int n,int m, int i, int j, int dirA[][])
    {
        if((i >=n) || (j >= m))
		{
			return 0;
		}
		if((i == n-1) && (j == m-1))
		{
			return 1;
		}
        return (findMazePaths(n, m, i+dirA[0][0], j+dirA[0][1]) + findMazePaths(n, m, i+dirA[1][0], j+dirA[1][1]) + findMazePaths(n, m, i+dirA[2][0], j+dirA[2][1]));
    }

    public static void findPaths(int n, int m, int i, int j, String ans, String dirS[])
    {
        if((i >=n) || (j >= m))
		{
			return;
		}
		if((i == n-1) && (j == m-1))
		{
            System.out.println(ans);
            return;
		}
        findPaths(n, m, i+1, j, ans+dirS[0], dirS);
        findPaths(n, m, i+1,j+1, ans+dirS[1], dirS);
        findPaths(n, m, i,j+1, ans+dirS[2], dirS);
    }

    public static void findPathsWithJumps(int n, int m, int i, int j, String ans, String dirS[])
    {
		if((i == n-1) && (j == m-1))
		{
            System.out.println(ans);
            return;
		}
        int count = 1;
        while((i+count) < n)
        {
            findPathsWithJumps(n, m, i+count, j, ans+dirS[0]+count, dirS);
            count++;
        }
        count = 1;
        while((i+count) < n && (j+count) < m)
        {
            findPathsWithJumps(n, m, i+count, j+count, ans+dirS[1]+count, dirS);
            count++;
        }
        count = 1;
        while((j+count) < m)
        {
            findPathsWithJumps(n, m, i, j+count, ans+dirS[2]+count, dirS);
            count++;
        }
    }
}