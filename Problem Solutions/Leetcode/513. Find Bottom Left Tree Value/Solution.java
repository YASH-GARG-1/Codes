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
    public int findBottomLeftValue(TreeNode root) {
        
        int ans = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(que.size() > 0)
        {
            int len = que.size();
            ans = que.peek().val;
            while(len-- > 0)
            {
                TreeNode temp = que.remove();
                if(temp.left != null)
                {
                    que.add(temp.left);
                }
                if(temp.right != null)
                {
                    que.add(temp.right);
                }
            }
        }
            
        return ans;
    }
}