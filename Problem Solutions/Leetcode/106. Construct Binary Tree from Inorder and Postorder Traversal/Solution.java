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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        for(int ele : inorder)
        {
            hm.put(ele, i++);
        }
        return makeTree(0, postorder.length-1, 0, inorder.length-1, postorder, inorder, hm);
    }
    
    public static TreeNode makeTree(int post_f, int post_r, int in_f, int in_r, int[] postorder, int[] inorder, HashMap<Integer, Integer> hm)
    {
        if(post_f > post_r || in_f > in_r)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[post_r]);
        int idx = hm.get(postorder[post_r]);
        int len = in_r - idx;
        node.left = makeTree(post_f, post_r-len-1, in_f , idx-1, postorder, inorder, hm);
        node.right = makeTree(post_r-len, post_r-1, idx+1 , in_r, postorder, inorder, hm);
        return node;
    }
}