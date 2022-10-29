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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null)
        {
            return true;
        }
        if(root.left == null || root.right == null)
        {
            return false;
        }
        return isSame(root.left,root.right);
    }
    
    public boolean isSame(TreeNode leftTree, TreeNode rightTree)
    {
        if(leftTree == null && rightTree == null)
        {
            return true;
        }
        if(leftTree == null || rightTree == null)
        {
            return false;
        }
        if(leftTree.val == rightTree.val)
        {
            return (isSame(leftTree.left, rightTree.right) && isSame(leftTree.right, rightTree.left));
        }
        return false;
    }
}