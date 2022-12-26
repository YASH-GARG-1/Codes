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
    public void flatten(TreeNode root) {
        
        if(root == null)
        {
            return;
        }
        TreeNode ans = preOrder(root);
        // root = ans;
        root.left = null;
        root.right = ans.right;
        root.val = ans.val;
    }
    public TreeNode preOrder(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode temp = new TreeNode(root.val);
        temp.left = null;
        temp.right = preOrder(root.left);
        TreeNode lastNode = temp;
        while(lastNode.right != null)
        {
            lastNode = lastNode.right;
        }
        lastNode.right = preOrder(root.right);
        return temp;
    }
}