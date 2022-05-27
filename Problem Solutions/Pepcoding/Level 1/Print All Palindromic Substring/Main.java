import java.util.Scanner;

public class Main
{
    public static boolean isPlindrome(String s)
    {
        int i,j;
        boolean val = true;
        j = s.length() - 1;
        for(i = 0;i<j;i++,j--)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                val = false;
                break;
            }
        }
        return val;
    }
    
	public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int n;
        n = s.length()-1;
        for(int i = 0; i <= n; i++)
        {
            for(int j = i; j<=n; j++)
            {
                // System.out.println(i+"  "+j);
                String ss = s.substring(i,j+1);
                if(isPlindrome(ss))
                {
                    System.out.println(ss);
                }
            }
        }
        scn.close();
	}
}
