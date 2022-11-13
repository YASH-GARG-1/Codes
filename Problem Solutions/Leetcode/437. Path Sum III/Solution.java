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
    
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        nodeTravel(root, targetSum);
        return count;
    }
    
    public void nodeTravel(TreeNode node, long targetSum)
    {
        if(node == null)
        {
            return;
        }
        
        pathSumTraversal(node, targetSum);
        
        nodeTravel(node.left, targetSum);
        nodeTravel(node.right, targetSum);
    }
    
    public void pathSumTraversal(TreeNode node, long targetSum)
    {
        if(node == null)
        {
            return;
        }
        if((targetSum - node.val) == 0)
        {
            count++;
        }
        pathSumTraversal(node.left, targetSum - node.val);
        pathSumTraversal(node.right, targetSum - node.val);
    }
}