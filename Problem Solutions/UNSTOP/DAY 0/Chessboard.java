import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Chessboard {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char ch = str.charAt(0);
        char ch2 = str.charAt(1);
        boolean val1 = false, val2 = false;
        if(ch == 'a' || ch == 'c' || ch == 'e' || ch == 'g')
        {
            val1 = true;
        }
        int num = ch2 - 48;
        if(num%2 == 1)
        {
            val2 = true;
        }
        if((val1 && val2) || (!val1 && !val2))
        {
            System.out.print("Black");
        }
        else
        {
            System.out.print("White");
        }
        scn.close();
    }
}