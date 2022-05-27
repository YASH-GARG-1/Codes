import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();
        int chess[][] = new int[n][n];
        printKnightsTour(chess,row,col,1);
        scn.close();
    }

    public static void printarr(int chess[][], int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(chess[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        int n = chess.length;
        if(r < 0 || c < 0 || r >= n || c >= n || chess[r][c] != 0)
        {
            return;
        }
        if(upcomingMove == (n*n))
        {
            chess[r][c] = upcomingMove;
            printarr(chess, n);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = upcomingMove;
        printKnightsTour(chess,r-2,c+1,upcomingMove+1);
        printKnightsTour(chess,r-1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+2,c+1,upcomingMove+1);
        printKnightsTour(chess,r+2,c-1,upcomingMove+1);
        printKnightsTour(chess,r+1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-2,c-1,upcomingMove+1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}