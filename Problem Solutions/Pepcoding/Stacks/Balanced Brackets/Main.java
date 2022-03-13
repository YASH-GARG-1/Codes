import java.util.*;

public class Main {
    
    public static boolean duplicateBracket(String s)
    {
        Stack<Character> st = new Stack<>();
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == ')')
            {
                count--;
                if(st.empty())
                {
                    return false;
                }
                while(!st.empty() && (st.peek() != '(') && (st.peek() != '[') && (st.peek()!= '{'))
                {
                    st.pop();
                }
                if(st.empty() || st.peek() != '(')
                {
                    return false;
                }
                st.pop();
            }
            else if(ch == '}')
            {
                count--;
                if(st.empty())
                {
                    return false;
                }
                while(!st.empty() && (st.peek() != '(') && (st.peek() != '[') && (st.peek()!= '{')){
                    st.pop();
                }
                if(st.empty() || st.peek() != '{')
                {
                    return false;
                }
                st.pop();
            }
            else if(ch == ']')
            {
                count--;
                if(st.empty())
                {
                    return false;
                }
                while(!st.empty() && st.peek() != '(' && st.peek() != '[' && st.peek()!= '{'){
                    st.pop();
                }
                if(st.empty() || st.peek() != '[')
                {
                    return false;
                }
                st.pop();
            }
            else
            {
                st.push(ch);
                if(ch == '(' || ch == '[' || ch == '{')
                {
                    count++;
                }
            }
        }
        if(count != 0)
        {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        boolean ans = duplicateBracket(s);
        System.out.println(ans);
        scn.close();
    }

}