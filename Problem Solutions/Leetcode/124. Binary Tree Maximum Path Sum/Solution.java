/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    static int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum;
    }
    
    public static int findSum(TreeNode root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        int leftVal = Math.max(findSum(root.left), 0);
        int rightVal = Math.max(findSum(root.right),0);
        int val = leftVal + rightVal + root.val;
        if(val > maxSum)
        {
            maxSum = val;
        }
        return ((int)Math.max(leftVal, rightVal) + root.val);
    }
}