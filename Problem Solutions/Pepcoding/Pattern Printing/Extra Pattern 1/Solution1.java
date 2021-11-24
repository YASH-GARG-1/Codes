import java.util.*;

public class Solution1{

    public static void extrapattern1(int n)
    {
        int num = 1;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1; j<=i;j++)
            {
                System.out.print(num+"\t");
            }
            num++;
            System.out.print("\n");
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : ");
        extrapattern1(n);
        scn.close();
    }
}