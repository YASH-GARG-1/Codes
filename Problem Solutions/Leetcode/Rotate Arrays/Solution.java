class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;
        if(k == 0)
        {
            return;
        }
        k = n-k;
        int arr[] = new int[n];
        for(int i = 0;i<n;i++)
        {
            arr[i] = nums[k];
            k = (k+1)%n;
        }
        for(int i = 0;i<n;i++)
        {
            nums[i] = arr[i];
        }
    }
}