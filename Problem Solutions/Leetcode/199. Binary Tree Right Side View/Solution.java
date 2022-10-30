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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root ==  null)
        {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        // ans.add(root.val);
        int prev = 0;
        while(que.size() > 0)
        {
            TreeNode temp = que.remove();
            if(temp == null)
            {
                ans.add(prev);
                if(que.size() > 0)
                {
                    que.add(null);
                }
            }
            else
            {
                prev = temp.val;
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