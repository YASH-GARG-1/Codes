class Solution {
    public int[][] merge(int[][] intervals) {
        
        Stack<int []> st = new Stack<>();
        Arrays.sort(intervals, (a,b)->{
           return a[0]-b[0]; 
        });
        
        st.push(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++)
        {
            int val[] = st.peek();
            int startVal = intervals[i][0];
            int endVal = intervals[i][1];
            if(startVal <= val[1])
            {
                st.pop();
                val[1] = Math.max(endVal, val[1]);
                st.push(val);
            }
            else
            {
                st.push(intervals[i]);
            }
        }
        
        int len = st.size();
        
        int ans[][] = new int[len][2];
        
        for(int i = len-1; i >= 0; i--)
        {
            int stVals[] = st.pop();
            ans[i][0] = stVals[0];
            ans[i][1] = stVals[1];
        }
        return ans;
    }
}