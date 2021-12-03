import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : \n");
        for(int i = n;i>0;i--)
        {
            for(int j = 1;j<=(n-i);j++)
            {
                System.out.print("\t");
            }
            for(int k = 1;k<=i;k++)
            {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
        scn.close();
    }
}