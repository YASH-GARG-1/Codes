import java.util.*;

public class Main {

    public static String checkEmail(String input1, String input2)
    {
        String ans = "";
        int count = 0, asc = -1, des = 500;
        boolean ascFlag = true, desFlag = true;
        for(int i = 0; i < input1.length(); i++)
        {
            char ch1 = input1.charAt(i);
            char ch2 = input2.charAt(i);
            if(ch1 != ch2)
            {
                count++;
            }
            int val = ch1;
            if(val > asc)
            {
                asc = val;
            }
            else
            {
                ascFlag = false;
            }
            if(val < des)
            {
                des = val;
            }
            else
            {
                desFlag = false;
            }
        }

        if(ascFlag)
        {
            ans = "Increasing" + ":" + count;
        }
        else if(desFlag)
        {
            ans = "Decreasing" + ":" + count;
        }
        else
        {
            ans = "Invalid";
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String str2 = scn.next();
        System.out.print(checkEmail(str, str2));
        scn.close();
    }
}
