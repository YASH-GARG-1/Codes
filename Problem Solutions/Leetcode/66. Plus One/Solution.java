class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        int idx = digits.length - 1;
        carry = (digits[idx] + 1)/10;
        digits[idx] = (digits[idx]+1)%10;
        idx--;
        while(carry > 0 && idx > -1)
        {
            carry = (digits[idx] + 1)/10;
            digits[idx] = (digits[idx]+1)%10;
            idx--;
        }
        if(idx == -1 && carry == 1)
        {
            int arr[] = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}