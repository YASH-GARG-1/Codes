import java.util.*;

public class Main {

    static String ref[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str,"");
        scn.close();
    }

    public static void printKPC(String str, String asf) {
        if(str.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String subStr = str.substring(1);
        int n = ch - '0';
        String ansStr = ref[n];
        int i;
        for(i = 0; i < ansStr.length(); i++)
        {
            ch = ansStr.charAt(i);
            printKPC(subStr,asf+ch);
        }
    }

}