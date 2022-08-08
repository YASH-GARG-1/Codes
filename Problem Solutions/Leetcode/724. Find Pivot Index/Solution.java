class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0, idx = -1;
        int len = nums.length;
        
        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
        }
        
        int leftSum = 0;
        
        for(int i = 0; i < len; i++)
        {
            int rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum)
            {
                idx = i;
                break;
            }
            leftSum += nums[i];
        }
        return idx;
    }
}
