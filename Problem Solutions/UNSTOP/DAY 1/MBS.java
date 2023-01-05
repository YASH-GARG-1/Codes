import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MBS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String ans = "";
        int len = str.length();
        int l = 0, r = 0;
        for(int i = 0; i < len; i++)
        {
            if(l==0 && r == 0)
            {
                ans += "(";
            }
            char ch = str.charAt(i);
            if(ch == 'R')
            {
                r++;
            }
            else
            {
                l++;
            }
            if(l == r)
            {
                ans += ch + ")";
                l = 0;
                r = 0;
            }
            else
            {
                ans += ch;
            }
        }
        System.out.print(ans);
        scn.close();
    }
}