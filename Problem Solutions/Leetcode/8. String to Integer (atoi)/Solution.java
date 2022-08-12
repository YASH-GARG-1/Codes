class Solution {
    public int myAtoi(String s) {
        
        int idx = 0;
        long num = 0;
        boolean isNegative = false;
        while(idx < s.length() && s.charAt(idx) == ' ')
        {
            idx++;
        }
        
        if(idx < s.length() && s.charAt(idx) == '-')
        {
            isNegative = true;
            idx++;
        }
        else if(idx < s.length() && s.charAt(idx) == '+')
        {
            isNegative = false;
            idx++;
        }
        
        int val = 0;
        if(idx < s.length())
            val = s.charAt(idx);
        
        while(idx < s.length() && val < 58 && val > 47)
        {
            int n = val - 48;
            num = num*10 + n;
            if(num > Integer.MAX_VALUE)
            {
                break;
            }
            idx++;
            if(idx < s.length())
                val = s.charAt(idx);
        }
        
        if(isNegative)
        {
            num = num*(-1);
        }
        
        if(num < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        
        if(num > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        
        return (int)num;
    }
}