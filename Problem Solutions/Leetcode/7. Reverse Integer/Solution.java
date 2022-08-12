class Solution {
    public int reverse(int x) {
        
        long num = 0;
        boolean isNegative = false;
        
        if(x < 0)
        {
            isNegative = true;
            x = x*(-1);
        }
        
        while(x > 0)
        {
            num = num * 10 + (x % 10);
            x = x / 10;
        }
        
        if(isNegative)
        {
            num = num * (-1);
            if(num < Integer.MIN_VALUE)
            {
                return 0;
            }
        }
        else if(num > Integer.MAX_VALUE)
        {
            return 0;
        }
        return (int)num;
    }
}