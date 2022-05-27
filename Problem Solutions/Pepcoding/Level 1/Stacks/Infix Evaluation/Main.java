import java.io.*;
import java.util.*;

public class Main{
  
  public static int precedence(char ch)
  {
      if(ch == '+' || ch == '-')
      {
          return 1;
      }
      return 2;
  }
  
  public static int calAns(int val2, int val1, char ch)
  {
      if(ch == '+')
      {
          return val1+val2;
      }
      else if(ch == '-')
      {
          return val1-val2;
      }
      else if(ch == '*')
      {
          return val1*val2;
      }
      else
      {
          return val1/val2;
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> digits = new Stack<>();
    Stack<Character> oper = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch <= '9')
        {
            int val = ch - '0';
            digits.push(val);
        }
        else if(ch == ' ')
        {
            continue;
        }
        else
        {
            if(ch == '(')
            {
                oper.push(ch);
            }
            else if(ch == ')')
            {
                while(!oper.empty() && oper.peek()!='(')
                {
                    int ans = calAns(digits.pop(), digits.pop(), oper.pop());
                    digits.push(ans);
                }
                oper.pop();
            }
            else
            {
                while(!oper.empty() && oper.peek()!='(' && precedence(oper.peek()) >= precedence(ch))
                {
                    int ans = calAns(digits.pop(), digits.pop(), oper.pop());
                    digits.push(ans);
                }
                oper.push(ch);
            }
        }
    }
    while(!oper.empty())
    {
        int ans = calAns(digits.pop(), digits.pop(), oper.pop());
        digits.push(ans);
    }
    System.out.print(digits.peek());
 }
}