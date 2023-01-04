import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ChessboardO {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int num = str.charAt(0) - 96;
        int num2 = str.charAt(1) - 48;
        if((num +num2)%2 == 0)
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