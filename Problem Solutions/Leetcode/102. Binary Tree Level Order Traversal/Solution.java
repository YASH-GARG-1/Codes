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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> Lis = new ArrayList<>();
        if(root == null)
        {
            return Lis;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(que.size()!=0)
        {
            List<Integer> eleList = new ArrayList<>();
            int Length = que.size();
            while(Length--!=0)
            {
                TreeNode ele = que.remove();
                    if(ele.left != null)
                        que.add(ele.left);
                    if(ele.right != null)
                        que.add(ele.right);
                    eleList.add(ele.val);
            }
            Lis.add(eleList);
        }
        return Lis;
    }
}