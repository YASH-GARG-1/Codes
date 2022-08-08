class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int len = t.length();
        int len2 = s.length();
        int j = 0;
        
        for(int i = 0; i < len && j < len2; i++)
        {
            char ch = t.charAt(i);
            char ch2 = s.charAt(j);
            if(ch == ch2)
            {
                j++;
            }
        }
        
        if(j != len2)
        {
            return false;
        }
        
        return true;
    }
}