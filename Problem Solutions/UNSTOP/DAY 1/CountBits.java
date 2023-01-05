import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class CountBits {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        System.out.print(findBits(num));
        scn.close();
    }

    static int findBits(int num)
    {
        if(num == 0)
        {
            return 0;
        }
        int pow = calPow(num);
        int prevBitsof2pow = pow * (1 << (pow-1));
        int otherBits = num - (1 << pow) + 1;
        int ans = prevBitsof2pow + otherBits + findBits(num - (1 << pow));
        return ans;
    }

    static int calPow(int num)
    {
        int pow = 0;
        while((1 << pow) <= num)
        {
            pow++;
        }
        return pow-1;
    }
}