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
    
    class Pair{
       
        int value;
        TreeNode node;
        
        Pair(TreeNode node)
        {
            this.value = 0;
            this.node = node;
        }
        
        Pair(int value, TreeNode node)
        {
            this.node = node;
            this.value = value;
        }
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        HashMap<Integer, Pair> map = new HashMap<>();
        NodeVal(root, map);
        Pair xPair = map.get(x);
        if(xPair.value == n && root.left == null && root.right == null)
        {
            return false;
        }
        if(xPair.node.left != null)
        {
            Pair leftVal = map.get(xPair.node.left.val);
            if((n - leftVal.value) < leftVal.value)
            {
                return true;
            }
        }
        if(xPair.node.right != null)
        {
            Pair rightVal = map.get(xPair.node.right.val);
            if((n - rightVal.value) < rightVal.value)
            {
                return true;
            }
        }
        
        if(xPair.node != root)
        {
            if((n - xPair.value) > xPair.value)
            {
                return true;
            }
        }
        return false;
    }
    
    public int NodeVal(TreeNode node, HashMap<Integer, Pair> map)
    {
        if(node == null)
        {
            return 0;
        }
        
        int leftVal = NodeVal(node.left, map);
        int rightVal = NodeVal(node.right, map);
        int totalVal = leftVal+rightVal + 1;
        map.put(node.val, new Pair(totalVal, node));
        return totalVal;
    }
}