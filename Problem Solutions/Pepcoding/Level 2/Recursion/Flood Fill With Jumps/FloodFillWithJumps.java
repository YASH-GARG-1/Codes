import java.util.*;

public class FloodFillWithJumps{
    
    public static class Pair{
        int len;
        String path;
        Pair()
        {
            len = 0;
            path = "";
        }
        Pair(int len,String path)
        {
            this.len = len;
            this.path = path;
        }
    }

    static int dirA[][] = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}}; 
    static String dirN[] = {"A","B","C","D","E","F","G","H"};
    static int minLen = Integer.MAX_VALUE;
    // Here minLen is taken to optimize the code as if we a string length is excedding the 
    // min length that no need to compute the ans for that string and simply stop.
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int visited[][] = new int[n][m];
        Pair ans = findPath(0,0,n-1,m-1,"", 0, visited);
        if(ans != null)
        {
            System.out.print("The Shortest Path in the Flood fill with jumps is of length : "+ans.len + " and");
            System.out.print(" the path is : "+ans.path);
        }
        scn.close();
    }

    public static Pair findPath(int sr, int sc, int dr, int dc, String asf, int len, int [][] visited)
    {
        if(sr > dr || sc > dc || sr < 0 || sc < 0 || minLen < len)
        {
            return null;
        }
        if(visited[sr][sc] == 1)
        {
            return null;
        }
        if(sr == dr && sc == dc)
        {
            System.out.println(asf);
            if(len < minLen)
            {
                minLen = len;
            }
            Pair ans = new Pair(len,asf);
            return ans;
        }
        Pair ans = null;
        visited[sr][sc] = 1;
        for(int i = 0; i < 8; i++)
        {
            int count = 1;
            while(((sr + dirA[i][0]*count) <= dr) && ((sc + dirA[i][1]*count) <= dc) && ((sr + dirA[i][0]*count) > 0) && ((sc + dirA[i][1]*count) > 0))
            {
                Pair pair = findPath(sr+dirA[i][0]*count, sc+dirA[i][1]*count, dr, dc, asf+dirN[i]+count, len+1, visited);
                if(pair != null)
                {
                    if(ans == null)
                    {
                        ans = pair;
                    }
                    else
                    {
                        if(pair.len <= ans.len)
                        {
                            ans = pair;
                        }
                    }
                }
                count++;
            }
        }
        visited[sr][sc] = 0;
        return ans;
    }
}
