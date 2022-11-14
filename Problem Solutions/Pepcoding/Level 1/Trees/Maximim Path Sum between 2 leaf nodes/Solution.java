static int maxSum = Integer.MIN_VALUE;
    public int findMaxSum(Node root)
    {
        maxSum = Integer.MIN_VALUE;
        helperFunction(root);
        return maxSum;
    }
    
    public static int helperFunction(Node node)
    {
        if(node == null)
        {
            return Integer.MIN_VALUE;
        }
        if(node.left == null && node.right == null)
        {
            return node.data;
        }
        int leftVal = helperFunction(node.left);
        int rightVal = helperFunction(node.right);
        int sum = leftVal + rightVal + node.data;
        if(sum > maxSum)
        {
            maxSum = sum;
        }
        
        return ((int)Math.max(leftVal, rightVal) + node.data);
    }