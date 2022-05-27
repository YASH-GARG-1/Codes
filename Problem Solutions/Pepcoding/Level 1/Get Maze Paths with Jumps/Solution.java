import java.util.*;

class Solution{

    public static void main(String[] args) throws Exception {
        Scanner scn  =new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0)
        {
            int n = scn.nextInt();
            int m = scn.nextInt();
            int k = scn.nextInt();
            System.out.println(getMazePathsT(n,m,k));
            t--;
        }
        scn.close();
    }

    // static int count = 0;

    // public static List<Integer> solve(int T, List<List<Integer>> a)
    // {
    //     List<Integer> arr = new ArrayList<Integer>();
    //     for(int i = 0; i < T; i++)
    //     {
    //         count = 0;
    //         int n = a.get(i).get(0);
    //         int m = a.get(i).get(1);
    //         int k = a.get(i).get(2);
    //         getMazePaths(1,1,n,m,k);
    //         arr.add(count);
    //     }
    //     return arr;
    // }

    // public static void getMazePaths(int sr, int sc, int dr, int dc, int k) {
    //     if((sr == dr)&&(sc == dc))
    //     {
    //         if(count == 1000000007)
    //         {
    //             count = 1;
    //         }
    //         else
    //         {
    //             count += 1;
    //         }
    //         return;
    //     }
    //     if(sc < dc)
    //     {
    //         int i = 1;
    //         while((sc+i)<=dc && i <= k)
    //         {
    //             getMazePaths(sr,sc+i,dr,dc,k);
    //             i++;
    //         }
    //     }
    //     if(sr < dr)
    //     {
    //         int i = 1;
    //         while((sr+i) <=dr && i <= k)
    //         {
    //             getMazePaths(sr+i,sc,dr,dc,k);
    //             i++;
    //         }
    //     }
    //     if((sc<dc)&&(sr<dr))
    //     {
    //         int i = 1;
    //         while(((sc+i)<=dc) && ((sr+i)<= dr) && i <= k)
    //         {
    //             getMazePaths(sr+i,sc+i,dr,dc,k);
    //             i++;
    //         }
    //     }
    // }

    public static int getMazePathsT(int dr, int dc, int k) {
        int arr[][] = new int[dr][dc];
        for(int i = dr-1; i>=0; i--)
        {
            for(int j = dc-1; j >= 0; j--)
            {
                if((i==dr-1) && (j == dc-1))
                {
                    arr[i][j] = 1;
                    continue;
                }
                int c = 0;
                for(int ele = 1; ele<=k && (i+ele)< dr; ele++)
                {
                    c = (c + arr[i+ele][j])%1000000007;
                }
                for(int ele = 1; ele<=k && (j+ele)< dc; ele++)
                {
                    c = (c + arr[i][j+ele])%1000000007;
                }
                for(int ele = 1; ele<=k && (i+ele)< dr && (j+ele)<dc; ele++)
                {
                    c = (c + arr[i+ele][j+ele])%1000000007;
                }
                arr[i][j] = c;
            }
        }
        return arr[0][0];
    }
}