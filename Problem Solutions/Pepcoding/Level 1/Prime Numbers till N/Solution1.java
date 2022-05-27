import java.util.*;
// Naive solution for printing all the prime numbers till n.
public class Solution1{
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the starting : ");
        int str = scn.nextInt();  //taking the starting point.
        System.out.print("Enter the ending : ");
        int endi = scn.nextInt(); //taking the ending point.
        int flag;  //To tell us whether a number is a prime no or not.
        if(str < 2)
        {
            str = 2;
        }
        System.out.println("All the prime numbers between the range are : ");
        for(;str<=endi;str++) //finding all the prime no. between the starting point and ending point. 
        {
            flag = 0;
            for(int i = 2; i*i<=str;i++)
            {
                if(str%i==0)
                {
                    flag = 1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println(str);
            }
        }
        scn.close();
    }
}
