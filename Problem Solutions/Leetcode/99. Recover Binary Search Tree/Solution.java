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
    public void recoverTree(TreeNode root) {
        
        TreeNode prev = null;
        TreeNode curr = root;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        while(curr != null)
        {
            if(curr.left == null)
            {
                if(prev != null && curr.val < prev.val)
                {
                    if(firstNode == null)
                    {
                        firstNode = prev;
                    }
                    secondNode = curr;
                }
                prev = curr;
                curr = curr.right;
            }
            else
            {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr)
                {
                    iop = iop.right;
                }
                
                if(iop.right == null)
                {
                    iop.right = curr;
                    curr = curr.left;
                }
                else
                {
                    iop.right = null;
                    if(prev != null && curr.val < prev.val)
                    {
                        if(firstNode == null)
                        {
                            firstNode = prev;
                        }
                        secondNode = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
    }
}