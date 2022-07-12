class Solution {
    
    static String [] strArr = {"n","abc","def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
        {
            return new ArrayList<>();
        }
        return letterComb(digits);
    }
    public List<String> letterComb(String digits)
    {
        if(digits.length() == 0)
        {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        List<String> ans = new ArrayList<>();
        char ch = digits.charAt(0);
        int num = ch;
        String str = strArr[num - 49];
        List<String> initialPart = letterComb(digits.substring(1)); 
        for(int i = 0; i < str.length(); i++)
        {
            char chr = str.charAt(i);
            for(String ele : initialPart)
            {
                String s = "";
                s = chr + ele;
                ans.add(s);
            }
        }
        return ans;
    }
}