public class VanshikaCode {
    
    public static int maxGroups(int input1, int [] input2)
    {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = input2.length;
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(input2[i]))
            {
                ans++;
                map.clear();
            }
            else
            {
                map.put(input2[i], 1);
            }
        }
        return ans;
    }
}
