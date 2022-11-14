class Solution {
    
    
    int idx, len;
    public TreeNode bstFromPostorder(int[] postorder) {
        
        idx = postorder.length-1;
        len = 0;
        // System.out.println("Check : 1");
        // return helperFunction(preorder, 0, preorder.length-1);
        return helperFunction(postorder, 0, 1001);
    }
    
    public TreeNode helperFunction(int[] postorder, int leftLimit, int rightLimit)
    {
        if(idx < 0)
        {
            return null;
        }
        
        TreeNode node = null;
        if(postorder[idx] >= leftLimit && postorder[idx] <= rightLimit)
        {
            node = new TreeNode();
            node.val = postorder[idx--];
            node.right = helperFunction(postorder, node.val, rightLimit);
            node.left = helperFunction(postorder, leftLimit, node.val);
        }
        return node;
    }
}