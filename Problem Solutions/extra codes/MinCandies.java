/* 
 ? Question : 

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Input Format:

The first and the only argument contains N integers in an array A.
Output Format:

Return an integer, representing the minimum candies to be given.
Example:

Input 1:
    A = [1, 2]

Output 1:
    3

Explanation 1:
    The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. 
    So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Input 2:
    A = [1, 5, 2, 1]

Output 2:
    7

Explanation 2:
    Candies given = [1, 3, 2, 1]
 */

import java.util.*;

class MinCandies{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }

        if(n == 1)
        {
            System.out.print("1");
        }
        else
        {
            int total_candies = 0;
            int dupArr[] = new int[n];
            dupArr[0] = 1;
            for(int i = 1; i < n; i++)
            {
                dupArr[i] = 1;
                if(arr[i] > arr[i-1])
                {
                    dupArr[i] = dupArr[i-1] + 1;
                }
            }
            total_candies += dupArr[n-1];
            for(int i = n-2; i > -1; i--)
            {
                if(arr[i] > arr[i+1])
                {
                    if(dupArr[i] <= dupArr[i+1])
                    {
                        dupArr[i] = dupArr[i+1] + 1;
                    }
                }
                total_candies += dupArr[i];
            }
            System.out.print(total_candies);
        }
        scn.close();
    }
}