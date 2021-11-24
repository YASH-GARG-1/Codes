import java.util.*;

public class Solution1{

    public static void pattern12(int n)
    {
        int a = 0,b = 1,c;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(a+"\t");
                c = a+b;
                a = b;
                b = c;
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern12(n);
        scn.close();
    }
}