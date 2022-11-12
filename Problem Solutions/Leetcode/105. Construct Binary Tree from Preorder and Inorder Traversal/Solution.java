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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        for(int ele : inorder)
        {
            hm.put(ele, i++);
        }
        return makeTree(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, hm);
    }
    
    public static TreeNode makeTree(int pre_f, int pre_r, int in_f, int in_r, int[] preorder, int[] inorder, HashMap<Integer, Integer> hm)
    {
        if(pre_f > pre_r || in_f > in_r)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[pre_f]);
        int idx = hm.get(preorder[pre_f]);
        int len = idx - in_f;
        node.left = makeTree(pre_f + 1, pre_f + len, in_f , idx-1, preorder, inorder, hm);
        node.right = makeTree(pre_f+len+1, pre_r, idx+1 , in_r, preorder, inorder, hm);
        return node;
    }
}