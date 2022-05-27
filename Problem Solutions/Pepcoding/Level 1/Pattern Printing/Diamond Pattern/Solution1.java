import java.util.*;

public class Solution1{
    
    public static void pattern4(int n)
    {
        int nsp = n/2,nst = 1;
        for(int r = 1; r <= n; r++)
        {
            for(int csp = 1; csp <= nsp; csp++)
            {
                System.out.print("\t");
            }
            for(int cst = 1; cst <= nst; cst++)
            {
                System.out.print("*\t");
            }
            if(r<=n/2)
            { 
                nsp--;
                nst+=2;
            }
            else
            {
                nsp++;
                nst-=2;
            }
            System.out.print("\n");
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value on n : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : ");
        pattern4(n);
        scn.close();
    }
}