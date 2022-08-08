class Solution {
    public int longestPalindrome(String s){
        
        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(hm.containsKey(ch))
            {
                int val = hm.get(ch);
                hm.put(ch,val+1);
            }
            else
            {
                hm.put(ch,1);
                hs.add(ch);
            }
        }
        
        int odd = -1;
        int sum = 0;
        for(Character ch : hs)
        {
            int val = hm.get(ch);
            if(val%2 == 0)
            {
                sum += val;
            }
            else
            {
                if(val > odd)
                {
                    if(odd > 1)
                    {
                        sum += odd - 1;
                    }
                    odd = val;
                }
                else
                {
                    if(val != 1)
                        sum += val - 1;
                }
            }
        }
        if(odd != -1)
        {
            sum += odd;
        }
        return sum;

        // for (Map.Entry<Character,Integer> mapElement : hm.entrySet())
        // {
        //     int val = mapElement.getValue();
        //     if(val%2 == 0)
        //     {
        //         sum += val;
        //     }
        //     else
        //     {
        //         sum += val - 1;
        //         odd = val;
        //     }
        // }
        // if(odd != -1)
        // {
        //     sum += 1;
        // }
    }
}