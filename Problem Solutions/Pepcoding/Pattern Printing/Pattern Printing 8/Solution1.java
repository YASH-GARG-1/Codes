import java.util.*;

public class Solution1{
    
    public static void pattern8(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if((i + j) == (n+1))
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern8(n);
        scn.close();
    }
}