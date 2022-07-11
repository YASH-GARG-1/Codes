import java.util.*;

public class FloodFill {
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int visisted[][] = new int[n][m];
        int dirA[][] = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}}; 
        String dirN[] = {"A","B","C","D","E","F","G","H"};
        System.out.println("No. of Paths are : " + findPaths(0,0,n-1, m-1, dirA,dirN,visisted, ""));
    }

    public static int findPaths(int sr, int sc, int dr, int dc, int dirA[][], String [] dirN, int visited[][], String ans)
    {
        if((sr > dr) || (sc > dc) || (sc < 0) || (sr < 0))
        {
            return 0;
        }
        if(visited[sr][sc] == 1)
        {
            return 0;
        }
        if((sr == dr) && (sc == dc))
        {
            System.out.println(ans);
            return 1;
        }
        int sum = 0;
        visited[sr][sc] = 1;
        for(int i = 0; i < 8; i++)
        {
            sum += findPaths(sr+dirA[i][0], sc+dirA[i][1], dr, dc, dirA, dirN, visited, ans+dirN[i]);
        }
        visited[sr][sc] = 0;
        return sum;
    }
}
