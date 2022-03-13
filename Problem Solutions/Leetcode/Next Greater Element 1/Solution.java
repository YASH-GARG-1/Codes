class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int ans[] = new int[m];
        int ngtr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            while(!st.empty() && nums2[st.peek()] < nums2[i])
            {
                int idx = st.pop();
                ngtr[idx] = nums2[i];
                hm.put(nums2[idx],ngtr[idx]);
            }
            st.push(i);
        }
        for(int i = 0; i < m; i++)
        {
            if(hm.containsKey(nums1[i]))
            {
                ans[i] = hm.get(nums1[i]);
            }
            else
            {
                ans[i] = -1;
            }
        }
        return ans;
    }
}