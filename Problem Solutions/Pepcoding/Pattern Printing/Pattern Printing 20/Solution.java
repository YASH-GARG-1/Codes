import java.util.*;

public class Solution{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : \n");
        int spc = 1;
        if(n == 1)
        {
            System.out.print("*");
        }
        else
        {
            for(int i = 1;i<=(n/2);i++)
            {
                System.out.print("*\t");
                for(int j = 1;j<=(n-2);j++)
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
            for(int i = 1;i<(n/2);i++)
            {
                //Working here.
                System.out.print("*\t");
                for(int j = 1;j<(n/2 - i);j++)
                {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for(int j = 1; j<=spc;j++)
                {
                    System.out.print("\t");
                }
                spc+=2;
                System.out.print("*\t");
                for(int j = 1;j<(n/2 - i);j++)
                {
                    System.out.print("\t");
                }
                System.out.println("*");
            }
            System.out.print("*\t");
            for(int j = 1;j<=(n-2);j++)
            {
                System.out.print("\t");
            }
            System.out.println("*");
        }
        scn.close();
    }
}