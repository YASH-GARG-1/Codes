class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int len = s.length();
        
        HashMap<Character,Character> hm = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();
        
        for(int i=0; i < len; i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(hm.containsKey(ch1))
            {
                char checkKey = hm.get(ch1);
                if(checkKey != ch2)
                {
                    return false;
                }
            }
            else
            {
                hm.put(ch1,ch2);
            }
            if(hm2.containsKey(ch2))
            {
                char checkKey = hm2.get(ch2);
                if(checkKey != ch1)
                {
                    return false;
                }
            }
            else
            {
                hm2.put(ch2,ch1);
            }
        }
        return true;
    }
}