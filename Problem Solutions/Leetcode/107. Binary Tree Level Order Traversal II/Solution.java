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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ansLis = new ArrayList<>();
        if(root == null)
        {
            return ansLis;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        List<Integer> lis = new ArrayList<>();
        while(que.size() > 0)
        {
            TreeNode temp = que.remove();
            if(temp == null)
            {
                ansLis.add(0,lis);
                lis = new ArrayList<>();
                if(que.size() > 0)
                {
                    que.add(null);
                }
            }
            else
            {
                lis.add(temp.val);
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
        
        return ansLis;
    }
}