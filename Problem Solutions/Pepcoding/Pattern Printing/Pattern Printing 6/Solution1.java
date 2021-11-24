import java.util.*;

public class Solution1{

    public static void pattern6(int n)
{
    int nst = (n+1)/2,nsp = 1;
    for(int r = 0; r<n; r++)
    {
        for(int cst = 1; cst<=nst; cst++)
        {
            System.out.print("*\t");
        }
        for(int csp = 1; csp<=nsp; csp++)
        {
            System.out.print("\t");
        }
        for(int cst = 1; cst<=nst; cst++)
        {
            System.out.print("*\t");
        }
        if(r<n/2)
        {
            nst--;
            nsp+=2;
        }
        else
        {
            nst++;
            nsp-=2;
        }
        System.out.print("\n");
    }
}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Ente the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern6(n);
        scn.close();
    }
}