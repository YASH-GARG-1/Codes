import java.util.*;

public class Solution1{

    public static void pattern15(int n)
    {
        int spc = n/2,dig = 1,num = 1;
        for(int i = 1;i<=n;i++)
        {
            for(int cspc = 1; cspc <= spc; cspc++)
            {
                System.out.print("\t");
            }
            for(int cdig = 1; cdig <= dig; cdig++)
            {
                System.out.print(num+"\t");
                if(cdig<=(dig/2))
                {
                    num++;
                }
                else
                {
                    num--;
                }
            }
            System.out.print("\n");
            if(i <= (n/2))
            {
                dig += 2;
                spc--;
                num = i+1;
            }
            else
            {
                dig -= 2;
                spc++;
                num = n - i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = scn.nextInt();
        System.out.println("The Pattern is : ");
        pattern15(n);
        scn.close();
    }
}