import java.util.*;

class MazePath{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int l = 0; l < T; l++)
        {
            int N = scn.nextInt();
            char arr[][] = new char[N][N];
            for(int i = 0; i < N; i++)
            {
                String str = scn.next(); 
                for(int j = 0; j < N; j++)
                {
                    arr[i][j] = str.charAt(j);
                }
            }
            System.out.println(numIslands(arr, N, N));
        }
        scn.close();
    }

    static int visitIsland(char grid[][], boolean visited[][], int i, int j, int row, int col)
    {
        if(visited[i][j] || grid[i][j] == '.')
        {
            return 0;
        }
        int ans = 0;
        visited[i][j] = true;
        if(i>0)
        {
            ans += visitIsland(grid,visited,i-1,j,row,col);
        }
        if((i+1) < row)
        {
            ans += visitIsland(grid,visited,i+1,j,row,col);
        }
        if(j > 0)
        {
            ans += visitIsland(grid,visited,i,j-1,row,col);
        }
        if(j+1 < col)
        {
            ans += visitIsland(grid,visited,i,j+1,row,col);
        }
        return ans;
    }
    
    static int numIslands(char[][] grid, int row, int col) {
        boolean [][] visited= new boolean[row][col];
        int num = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    if(visitIsland(grid,visited,i,j,row,col) >= 7)
                    {
                        num++;
                    }
                }
            }
        }
        return num;
    }

}