import java.util.*;

public class Solution1{

    public static void pattern14(int n)
    {
        for(int i = 1;i<=10;i++)
        {
            System.out.println(n + " * "+i+" = "+(n*i));
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        pattern14(n);
        scn.close();
    }
}