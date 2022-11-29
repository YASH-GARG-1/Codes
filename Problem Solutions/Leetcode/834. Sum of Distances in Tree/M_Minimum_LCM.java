import java.util.*;

public class M_Minimum_LCM
{
    public static boolean checkPrime(Long num)
    {
        if(num == 1)
        {
            return false;
        }

        for(long i = 2; i*i <= num; i++)
        {
            if(num%i == 0)
            {
                return false;
            }
        }
        return true;
    } 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int count = 0; count < t; count++)
        {
            long num = scn.nextLong();
            if (checkPrime(num))
            {
                System.out.println(1 + " " + (num - 1));
            }
            else
            {
                for (long i = 2; i * i <= num; i++)
                {
                    if (num % i == 0)
                    {
                        System.out.println(num / i + " " +(num / i * (i - 1)));
                        break;
                    }
                }
            }
        }
        scn.close();
    }
}