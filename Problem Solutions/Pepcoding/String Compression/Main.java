import java.util.*;

public class Main {

	public static String compression1(String str){
		// write your code here
		String newstr = "";
		char lastch = str.charAt(0);
		newstr = newstr + lastch;
		for(int i = 1; i < str.length(); i++)
		{
		    if(str.charAt(i) != lastch)
		    {
		        lastch = str.charAt(i);
		        newstr = newstr + lastch;
		    }
		}
		return newstr;
	}

	public static String compression2(String str){
		// write your code here
        String newstr = "";
        int count = 1;
		char lastch = str.charAt(0);
		newstr = newstr + lastch;
		for(int i = 1; i < str.length(); i++)
		{
		    if(str.charAt(i) != lastch)
		    {
		        lastch = str.charAt(i);
		        if(count>1)
		        {
		            newstr = newstr + count +lastch;
		            count = 1;
		        }
		        else
		        {
		            newstr = newstr + lastch;
		        }
		    }
		    else
		    {
		        count++;
		    }
		}
		if(count>1)
		{
		    newstr = newstr + count;
		}
		return newstr;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
        scn.close();
	}

}