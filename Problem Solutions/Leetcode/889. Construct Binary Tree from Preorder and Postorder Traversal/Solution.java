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
    HashMap<Integer, Integer> hm;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len = preorder.length;
        hm = new HashMap<>();
        int idx = 0;
        for(int ele : postorder)
        {
            hm.put(ele, idx++);
        }
        return createTree(preorder, postorder, 0, len-1, 0, len-1);
    }
    
    public TreeNode createTree(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd)
    {
        if(preStart > preEnd || postStart > postEnd)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preStart]);
        if(preStart != preEnd)
        {
            int idx = hm.get(preorder[preStart+1]);
            int len = idx-postStart;
            node.left = createTree(preorder, postorder, preStart+1, preStart+len+1, postStart,idx);
            node.right = createTree(preorder, postorder, preStart+len+2, preEnd, idx+1,postEnd-1);
        }
        return node;
    }
}