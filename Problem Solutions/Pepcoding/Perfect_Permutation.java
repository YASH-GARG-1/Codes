/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
// class Codechef
class Perfect_Permutation
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner scn = new Scanner(System.in);
        int l = scn.nextInt();
        for(int i = 0; i < l; i++)
        {
            int n = scn.nextInt();
            int k = scn.nextInt();
            PerfectPermutation(n,k);
        }
        scn.close();
	}

    public static void PerfectPermutation(int n, int k)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 1; i < n+1; i++)
        {
            arrList.add(i);
        }
        if(n == 1)
        {
            System.out.println("1");
            return;
        }
        else if(k == (n-1))
        {
            Collections.swap(arrList, 0, 1);
            for(int i = 0; i < arrList.size(); i++)
            {
                System.out.print(arrList.get(i)+" ");
            }
            System.out.print("\n");
            return;
        }
        else
        {
            int idx = 0;
            k = n - k;
            for(int i = 0; i < k; i++)
            {
                Collections.swap(arrList, idx, idx+1);
                idx += 1;
            }
            for(int i = 0; i < arrList.size(); i++)
            {
                System.out.print(arrList.get(i)+" ");
            }
            System.out.print("\n");
        }
    }
}
