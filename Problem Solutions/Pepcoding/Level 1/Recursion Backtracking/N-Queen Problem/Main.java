import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int visited[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        printNQueens(visited,"",0);
        scn.close();
    }

    public static int[][] initArray(int chess[][], int val, int n,int row,int i)
    {
        for(int j = 0; j < n; j++)
        {
            chess[row][j] = chess[row][j] + val;
        }
        for(int k = 0; k < n; k++)
        {
            chess[k][i] = chess[k][i] + val;
        }
        for(int j = row,k = i; j>=0 && k>=0; j--,k--)
        {
            chess[j][k] = chess[j][k] + val;
        }
        for(int j = row,k = i; j<n && k<n; j++,k++)
        {
            chess[j][k] = chess[j][k] + val;
        }
        for(int j = row,k = i; j>=0 && k<n; j--,k++)
        {
            chess[j][k] = chess[j][k] + val;
        }
        for(int j = row,k = i; j<n && k>=0; j++,k--)
        {
            chess[j][k] = chess[j][k] + val;
        }
        chess[row][i] = chess[row][i] -(5*val);
        return chess;
    }
    
    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length)
        {
            System.out.println(qsf+".");
            return;
        }
        int n = chess.length;

        for(int i = 0; i < n; i++)
        {
            if(chess[row][i] == 0)
            {
                chess = initArray(chess,1,n,row,i);
                printNQueens(chess,qsf+row+"-"+i+", ",row+1);
                chess = initArray(chess,-1,n,row,i);
            }
        }
    }
}