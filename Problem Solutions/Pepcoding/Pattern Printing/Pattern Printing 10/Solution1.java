import java.util.*;

public class Solution1{

public static void pattern10(int n)
{
    int osp = n/2,isp = 0;
    for(int i = 1;i<=n;i++)
    {
        if(i == 1 || i == n)
        {
            for(int cosp = 1; cosp<=osp; cosp++)
            {
                System.out.print("\t");
            }
            System.out.println("*\t");
        }
        else
        {
            for(int cosp = 1; cosp<=osp; cosp++)
            {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int cisp = 1; cisp<=isp; cisp++)
            {
                System.out.print("\t");
            }
            System.out.println("*\t");
        }
        if(i<=(n/2))
        {
            osp--;
            if(isp == 0)
                isp = 1;
            else
                isp+=2;
        }
        else
        {
            osp++;
            isp-=2;
        }
    }
}

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the value of n : ");
    int n = scn.nextInt();
    System.out.println("The PAttern is : ");
     pattern10(n);
     scn.close();
 }
}