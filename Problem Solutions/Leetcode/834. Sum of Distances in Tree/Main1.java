/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main1
{
	public static void main(String[] args) {
		int[][] arr = { { 2,4,6,-1 }, { -1,4,5,6 } ,{7,5,8,3}, {4,3,6,7}};
		print(arr,4,4);
		result(arr,4,4);
		System.out.print("\n\n\n");
		print(arr,4,4);
	}
	
	public static void print(int [][] values,int rows, int cols)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                System.out.print(values[i][j] + "   ");
            }
            System.out.print("\n");
        }
    }
	public static void result(int [][] values,int rows, int cols)
    {
        for(int j = 0; j < cols; j++)
        {
            int min = -1;
            int idx = -1;
            for(int i = 0; i < rows; i++)
            {
                int ele = values[i][j];
                if(ele == -1)
                {
                    idx = i;
                    continue;
                }
                else
                {
                    if(min == -1 && ele != -1)
                    {
                        min = ele;
                        // continue;    
                    }
                    else if(min > ele && ele != -1)
                    {
                        min = ele;
                    }
                }
            }
            if(idx != -1)
            {
                values[idx][j] = min;
            }
        }
    }
}
