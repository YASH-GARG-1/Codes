//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class SolutionGFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                String[] s = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                char[][] grid = new char[n][m];
                for (int i = 0; i < n; i++) {
                    String[] S = br.readLine().trim().split(" ");
                    for (int j = 0; j < m; j++) {
                        grid[i][j] = S[j].charAt(0);
                    }
                }
                Solution obj = new Solution();
                int ans = obj.numIslands(grid);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        // * Function to find the number of islands.
        public int numIslands(char[][] grid) {
            // Code here
            int count =0;
            int n = grid.length;
            int m = grid[0].length;
            boolean visited[][] = new boolean[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    if(grid[i][j] == '1' && !visited[i][j])
                    {
                        dfs(grid, i, j,n,m,visited);
                        count++;
                    }
                }
            }
            return count;
        }
        
        public void dfs(char[][] grid, int i, int j, int n, int m, boolean visited[][])
        {
            // ! Checking whether we are in the grid range or not. 
            if(i >= n || i < 0 || j < 0 || j >= m)
            {
                return;
            }
            // * if it is already visited or it is not an island part.
            if(visited[i][j] || grid[i][j] == '0')
            {
                return;
            }
            
            visited[i][j] = true;
            for(int k = -1; k <= 1; k++)
            {
                for(int l = -1; l <= 1; l++)
                {
                    if(k ==0 && l == 0)
                    {
                        continue;
                    }
                    dfs(grid, i+k, j+l, n, m, visited);
                }
            }
        }
    }