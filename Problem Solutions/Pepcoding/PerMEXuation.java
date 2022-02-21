/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
// class Codechef
class PerMEXuation
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 0; i < n; i++)
        {
            int k = scn.nextInt();
            String str = scn.next();
            SolvePerMEX(k,str);
        }
        scn.close();
	}

    public static void SolvePerMEX(int k, String str)
    {
        int h = 1;
        if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(k) == '0')
        {
            System.out.println("No");
            return;
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(0);
        for(int i = 2; i < str.length() - 1; i++)
        {
            if(str.charAt(i) == '0')
            {
                arrList.add(i);
            }
            else
            {
                arrList.add(h);
                h = i;
            }
        }
        arrList.add(h);
        System.out.println("Yes");
        for(int i = 0; i < arrList.size(); i++)
        {
            System.out.print(arrList.get(i)+" ");
        }
        System.out.print("\n");
    }
}
