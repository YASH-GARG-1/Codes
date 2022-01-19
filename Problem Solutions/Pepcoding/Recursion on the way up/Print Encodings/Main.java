import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
        scn.close();
    }

    public static void printEncodings(String str, String ans) {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        int n = ch - '0';
        if(n > 0)
        {
            int n1 = n + 96;
            ch = (char)n1;
            printEncodings(str.substring(1),ans+ch);
        }
        if((str.length()>=2) && n != 0)
        {
            ch = str.charAt(1);
            int n2 = ch - '0';
            n2 = n*10 + n2;
            if(n2<=26)
            {
                n2 = n2+96;
                ch = (char)n2;
                printEncodings(str.substring(2),ans+ch);
            }
        }
    }

}