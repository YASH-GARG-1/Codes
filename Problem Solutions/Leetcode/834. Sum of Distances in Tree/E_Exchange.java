import java.util.*;

public class E_Exchange
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int count = 0; count < t; count++)
        {
            long num = scn.nextLong();
            long gold = scn.nextLong();
            long silver = scn.nextLong();
            if(gold > silver)
            {
                System.out.println("1");
            }
            else
            {
                if(num%gold == 0)
                {
                    System.out.println(num/gold);
                }
                else
                {
                    System.out.println(num/gold + 1);
                }
            }
        }
        scn.close();
    }
}