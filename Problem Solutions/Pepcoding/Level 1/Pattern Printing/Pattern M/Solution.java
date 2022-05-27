import java.util.*;

public class Solution{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : \n");
        int spc = n-4;
        // write ur code here
        if(n == 1)
        {
            System.out.print("*");
        }
        else
        {
            System.out.print("*\t");
            for(int j = 1;j<=(n-2);j++)
            {
                System.out.print("\t");
            }
            System.out.println("*");
            
            for(int i = 1;i<(n/2);i++)
            {
                System.out.print("*\t");
                for(int j = 2;j<=i;j++)
                {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for(int j = 1; j<=spc;j++)
                {
                    System.out.print("\t");
                }
                spc-=2;
                System.out.print("*\t");
                for(int j = 2;j<=i;j++)
                {
                    System.out.print("\t");
                }
                System.out.println("*");
            }
            
            System.out.print("*\t");
            for(int i = 1;i<(n/2);i++)
            {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int i = 1;i<(n/2);i++)
            {
                System.out.print("\t");
            }
            System.out.println("*");
            for(int i = 1;i<=(n/2);i++)
            {
                System.out.print("*\t");
                for(int j = 1;j<=(n-2);j++)
                {
                    System.out.print("\t");
                }
                System.out.println("*");
            }
        }
        scn.close();
    }
}