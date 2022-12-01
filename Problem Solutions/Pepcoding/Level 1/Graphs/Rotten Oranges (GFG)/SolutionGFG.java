//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class SolutionGFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] s = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int[][] grid = new int[n][m];
                for(int i = 0; i < n; i++){
                    String[] S = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++){
                        grid[i][j] = Integer.parseInt(S[j]);
                    }
                }
                Solution obj = new Solution();
                int ans = obj.orangesRotting(grid);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        public class Pair
        {
            int row;
            int col;
            
            Pair(int row, int col)
            {
                this.row = row;
                this.col = col;
            }
        }
        //Function to find minimum time required to rot all oranges. 
        public int orangesRotting(int[][] grid)
        {
            int count = -1;
            int n = grid.length;
            int m = grid[0].length;
            int unrottenCount = 0;
            // boolean visited[][] = new boolean[n][m];
            Queue<Pair> que = new LinkedList<>();
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    if(grid[i][j] == 2)
                    {
                        que.add(new Pair(i,j));
                    }
                    else if(grid[i][j] == 1)
                    {
                        unrottenCount++;
                    }
                }
            }
    
            int arr[][] = {{0,-1}, {0,1}, {1,0}, {-1,0}};
            while(que.size() > 0)
            {
                int len = que.size();
                while(len-- > 0)
                {
                    Pair pair = que.remove();
                    for(int i = 0; i < 4; i++)
                    {
                        int r = pair.row + arr[i][0];
                        int c = pair.col + arr[i][1];
                        if(r > -1 && c > -1 && r < n && c < m && grid[r][c] == 1)
                        {
                            grid[r][c] = 2;
                            que.add(new Pair(r,c));
                            unrottenCount--;
                        }
                    }
                }
                count++;
            }
            
            if(unrottenCount > 0)
            {
                return -1;
            }
            else
            {
                return count;
            }
        }
    }