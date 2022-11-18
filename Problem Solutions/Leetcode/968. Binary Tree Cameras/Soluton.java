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
    
    int notCovered = 0;
    int covered = 1;
    int camera = 2;
    
    int count = 0;
    public int minCameraCover(TreeNode root) {
        
        int ans = calFun(root);
        if(ans == notCovered)
        {
            count++;
        }
        return count;
    }
    
    public int calFun(TreeNode node)
    {
       if(node == null)
       {
           return covered;
       }
        
        int left = calFun(node.left);
        int right = calFun(node.right);
        
        if(left == notCovered || right == notCovered)
        {
            count++;
            return camera;
        }
        else if(right == camera || left == camera)
        {
            return covered;
        }
        
        return notCovered;
    }
}