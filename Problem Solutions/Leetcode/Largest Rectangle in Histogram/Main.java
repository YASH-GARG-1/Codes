class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nstl[] = nextSmallestToLeft(n,heights);
        int nstr[] = nextSmallestToRight(n,heights);
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            int ans = (nstr[i] - nstl[i] - 1)*heights[i];
            if(ans > max)
            {
                max = ans;
            }
        }
        return max;
    }
    
    public int[] nextSmallestToLeft(int n, int arr[])
    {
        int nstl[] = new int[n];
        Arrays.fill(nstl,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            while(!st.empty() && arr[st.peek()] > arr[i])
            {
                nstl[st.pop()] = i; 
            }
            st.push(i);
        }
        return nstl;
    }
    
    public int[] nextSmallestToRight(int n, int arr[])
    {
        int nstr[] = new int[n];
        Arrays.fill(nstr,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!st.empty() && arr[st.peek()] > arr[i])
            {
                nstr[st.pop()] = i; 
            }
            st.push(i);
        }
        for(int i = 0; i < n; i++)
        {
            if(nstr[i] == -1)
            {
                nstr[i] = n;
            }
        }
        return nstr;
    }
}