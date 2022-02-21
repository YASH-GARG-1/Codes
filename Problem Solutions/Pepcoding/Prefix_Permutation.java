/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
// class Codechef
class Prefix_Permutation
{
    static Scanner scn = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        int n = scn.nextInt();
        for(int i = 0; i < n; i++)
        {
            PrefixPermutation();
        }
	}

    public static void PrefixPermutation()
    {
        int n = scn.nextInt();
        int k = scn.nextInt();
        int arr[] = new int[k];
        for(int i = 0; i < k; i++)
        {
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> arrLis = new ArrayList<>();
        int pre = 0;
        for(int i = 0; i < k; i++)
        {
            for(int j = arr[i]; j > pre; j--)
            {
                arrLis.add(j);
            }
            pre = arr[i];
        }
        for(int i = 0; i < arrLis.size(); i++)
        {
            System.out.print(arrLis.get(i)+" ");
        }
        System.out.print("\n");
    }
}
