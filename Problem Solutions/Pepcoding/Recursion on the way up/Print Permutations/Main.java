import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str,"");
        scn.close();
    }

    public static void printPermutations(String str, String asf) {
        if(str.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        char ch;
        String str1,str2;
        for(int i = 0; i < str.length(); i++)
        {
            ch = str.charAt(i);
            str1 = str.substring(0,i);
            str2 = str.substring(i+1);
            printPermutations(str1+str2,asf+ch);
        }
    }

}