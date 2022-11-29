import java.util.*;

public class B_Broken_Keyboard
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        for(int i = 0; i < t; i++)
        {
            int len = scn.nextInt();
            String str = scn.next();
            boolean secondChar = false;
            boolean ans = true;
            for(int j = 0; j < str.length(); j++)
            {
                if(secondChar)
                {
                    char ch = str.charAt(j);
                    if(j+1 == len)
                    {
                        ans = false;
                        break;
                    }
                    char ch2 = str.charAt(j+1);
                    if(ch != ch2)
                    {
                        ans = false;
                        break;
                    }
                    j++;
                    secondChar = false;
                }
                else
                {
                    secondChar = true;
                }
            }
            if(ans)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        scn.close();
    }
}