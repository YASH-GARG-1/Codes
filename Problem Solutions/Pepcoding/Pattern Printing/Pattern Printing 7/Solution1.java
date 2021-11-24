import java.util.*;

public class Solution1{
    
    public static void pattern7(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                if(i == j)
                {
                    System.out.println("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern7(n);
        scn.close();
    }
}