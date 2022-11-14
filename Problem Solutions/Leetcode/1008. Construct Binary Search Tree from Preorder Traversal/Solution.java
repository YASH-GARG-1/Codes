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
    public TreeNode bstFromPreorder(int[] preorder) {
        // System.out.println("Check : 1");
        return helperFunction(preorder, 0, preorder.length-1);
    }
    
    public static int binarySearch(int start, int end, int[] preorder)
    {
        // System.out.println("Check : 2");
        if(start+1 > end)
        {
            // System.out.println("Check : 3");
            return -1;
        }
        int val = preorder[start];
        start = start+1;
        while(start <= end)
        {
            // System.out.println("Check : 4");
            int mid = start + (end-start)/2;
            if(preorder[mid] > val && preorder[mid-1] <= val)
            {
                // System.out.println("Check : 5");
                return mid;
            }
            else if(preorder[mid] < val)
            {
                // System.out.println("Check : 6");
                start = mid+1;
            }
            else
            {
                // System.out.println("Check : 7");
                end = mid-1;
            }
        }
        // System.out.println("Check : 8");
        return -1;
    }
    
    public static TreeNode helperFunction(int[] preorder, int start, int end)
    {
        // System.out.println("Check : 9");
        if(start > end)
        {
            // System.out.println("Check : 10");
            return null;
        }
        
        int val = preorder[start];
        
        TreeNode node = new TreeNode();
        node.val = preorder[start];
        
        if(start == end)
        {
            // System.out.println("Check : 11");
            return node;
        }
        // System.out.println("Check : 12");
        int rightidx = binarySearch(start, end, preorder);
        
        if(rightidx != -1)
        {
            // System.out.println("Check : 13");
            node.left = helperFunction(preorder, start+1, rightidx-1);
            node.right = helperFunction(preorder, rightidx, end);
        }
        else
        {
            // System.out.println("Check : 14");
            node.left = helperFunction(preorder, start+1, end);
            node.right = null;
        }
        // System.out.println("Check : 15");
        return node;
    }
}