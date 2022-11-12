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
    public int countNodes(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        
        TreeNode temp = root.left;
        int left = 0, right = 0;
        while(temp != null)
        {
            left++;
            temp = temp.left;
        }
        temp = root.right;
        while(temp != null)
        {
            right++;
            temp = temp.right;
        }
        if(left == right)
        {
            return (1<<(left+1)) - 1; // 1<<5 is same as 2^5
        }
        else
        {
            return (countNodes(root.left) + countNodes(root.right) + 1);
        }
    }
}