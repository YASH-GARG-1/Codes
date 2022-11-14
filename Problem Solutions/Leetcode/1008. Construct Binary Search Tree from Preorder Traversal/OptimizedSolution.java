class OptimizedSolution {
    
    int idx, len;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        idx = 0;
        len = preorder.length-1;
        // System.out.println("Check : 1");
        // return helperFunction(preorder, 0, preorder.length-1);
        return helperFunction(preorder, 0, 1001);
    }
    
    public TreeNode helperFunction(int[] preorder, int leftLimit, int rightLimit)
    {
        if(idx > len)
        {
            return null;
        }
        
        TreeNode node = null;
        if(preorder[idx] >= leftLimit && preorder[idx] <= rightLimit)
        {
            node = new TreeNode();
            node.val = preorder[idx++];
            node.left = helperFunction(preorder, leftLimit, node.val);
            node.right = helperFunction(preorder, node.val, rightLimit);
        }
        return node;
    }