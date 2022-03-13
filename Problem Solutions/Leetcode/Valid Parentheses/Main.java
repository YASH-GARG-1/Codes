class Solution {
    public boolean isValid(String s) {
        
        boolean flag = true;
        Stack<Character> st = new Stack<>();        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
            {
                st.push(ch);
            }
            else
            {
                if(st.empty())
                {
                    flag = false;
                    break;
                }
                else
                {
                    if(ch == ')' && st.peek() != '(')
                    {
                        return false;
                    }
                    else if(ch == '}' && st.peek() != '{')
                    {
                        return false;
                    }
                    else if(ch == ']' && st.peek() != '[')
                    {
                        return false;
                    }
                    else
                    {
                        st.pop();
                    }
                }
            }
        }
        
        if(!st.empty())
        {
            flag = false;
        }
        return flag;
    }
}