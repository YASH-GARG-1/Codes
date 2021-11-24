import java.util.*;

public class Solution1{

    public static void extrapattern2(int n)
    {
        int num = 1,osp = n/2,digp = 1;
        for(int i = 1;i<=n;i++)
        {
            for(int cosp = 1; cosp <= osp; cosp++)
            {
                System.out.print("\t");
            }
            for(int cdigp = 1; cdigp <= digp; cdigp++)
            {
                System.out.print(num+"\t");
            }
            System.out.print("\n");
            if(i<=(n/2))
            {
                osp--;
                digp+=2;
                num++;
            }
            else
            {
                osp++;
                digp-=2;
                num--;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the value of N : ");
        int n = scn.nextInt();
        System.out.println("The pattern is : ");
        extrapattern2(n);
        scn.close();
    }
}