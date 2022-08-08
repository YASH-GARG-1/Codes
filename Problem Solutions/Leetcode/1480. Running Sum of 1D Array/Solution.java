class Solution {
    public int[] runningSum(int[] nums) {
        // int len = nums.length;
        // int ans[] = new int[len];
        // int sum = 0;
        // for(int i = 0; i < len; i++)
        // {
        //     ans[i] = nums[i] + sum;
        //     sum += nums[i];
        // }
        // return ans;
        
        int len = nums.length;
        int sum = 0, prev = -1;
        for(int i = 0; i < len; i++)
        {
            prev = nums[i];
            nums[i] = sum = sum + prev;
        }
        return nums;
    }
}