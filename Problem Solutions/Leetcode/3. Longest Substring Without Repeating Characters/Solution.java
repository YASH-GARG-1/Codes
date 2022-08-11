class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
        {
            return 0;
        }
        int st = 0,end = 0;
        int maxLen = 0,len = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(hm.containsKey(ch))
            {
                int idx = hm.get(ch);
                while(st <= idx)
                {
                    char cha = s.charAt(st);
                    hm.remove(cha);
                    st++;
                    len--;
                }
            }
            end++;
            len++;
            hm.put(ch, i);
            
            if(maxLen < len)
            {
                maxLen = len;
            }
        }
        return maxLen;
    }
}