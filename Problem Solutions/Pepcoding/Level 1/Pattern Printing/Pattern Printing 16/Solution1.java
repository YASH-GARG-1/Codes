import java.util.*;

public class Solution1{
    
    public static void pattern16(int n)
    {
        int spc = n*2 - 3,num;
        for(int i = 1;i<=n;i++)
        {
            for(num = 1; num <= i; num++)
            {
                System.out.print(num+"\t");
            }
            for(int cspc = 1; cspc <= spc; cspc++)
            {
                System.out.print("\t");
            }
            if(i == n)
            {
                num = n-1;
            }
            else
            {
                num = i;
            }
            for(; num>=1; num--)
            {
                System.out.print(num+"\t");
            }
            System.out.print("\n");
            spc -=2;
        }
    }

    public static void main(String[] args) {
    
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern16(n);
        scn.close();
    }
}