import java.io.*;
import java.util.*;

public class Main{
  
  public static int cal(int val2, int val1, char ch)
  {
      if(ch == '*')
      {
          return val2*val1;
      }
      else if(ch == '+')
      {
          return val1+val2;
      }
      else if(ch == '/')
      {
          return val1/val2;
      }
      else
      {
          return val1-val2;
      }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> eval = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);
        if(ch >= '0' && ch <= '9')
        {
            int n = ch - '0';
            eval.push(n);
            infix.push(ch);
            prefix.push(ch);
        }
        else
        {
            int ans = cal(eval.pop(), eval.pop(), ch);
            eval.push(ans);
            String str2 = infix.pop();
            String str1 = infix.pop();
            String str = "(" + str1+ch+str2+ ")";
            infix.push(str);
            str2 = prefix.pop();
            str1 = prefix.pop();
            str = ch+str1+str2;
            prefix.push(str);
        }
    }
    System.out.println(eval.peek());
    System.out.println(infix.peek());
    System.out.print(prefix.peek());
 }
}