import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure
    
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

************************************************************/

public class CodeStudioSol{
    static long maxSum;
    public static long findMaxSumPath(TreeNode root)
    {
//         maxSum = Long.MIN_VALUE;
        maxSum = -1;
        helperFunction(root);
        return maxSum;
    }
    
    public static long helperFunction(TreeNode node)
    {
        if(node == null)
        {
//             return Long.MIN_VALUE;
            return -1;
        }
        if(node.left == null && node.right == null)
        {
            return node.data;
        }
        long sum = -1;
        long leftVal = helperFunction(node.left);
        long rightVal = helperFunction(node.right);
        if(leftVal != -1 && rightVal != -1)
            sum = leftVal + rightVal + node.data;
        if(sum > maxSum)
        {
            maxSum = sum;
        }
        
        return (Math.max(leftVal, rightVal) + (long)node.data);
    }
}