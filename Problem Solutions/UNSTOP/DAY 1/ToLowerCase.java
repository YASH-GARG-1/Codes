import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ToLowerCase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int len = str.length();
        String ans = "";
        for(int i = 0; i < len; i++)
        {
            char ch = str.charAt(i);
            int val = ch;
            if(val < 91 && val > 64)
            {
                val = val + 32;
            }
            ch = (char)val;
            ans += ch;
        }
        System.out.print(ans);
        scn.close();
    }
}