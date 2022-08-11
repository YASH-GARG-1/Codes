class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        if(ans == "")
        {
            return ans;
        }
        
        for(int i = 1; i < strs.length && (ans != ""); i++)
        {
            String str = "";
            for(int j = 0; j < strs[i].length() && j < ans.length(); j++)
            {
                if(strs[i].charAt(j) == ans.charAt(j))
                {
                    str = str + ans.charAt(j);
                }
                else 
                {
                    break;
                }
            }
            ans = str;
        }
        return ans;
    }
}