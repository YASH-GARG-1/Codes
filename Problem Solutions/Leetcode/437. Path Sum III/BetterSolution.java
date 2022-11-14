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

// Using the prefix sum to get the answer.
class BetterSolution {
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put((long)0, 1);
        return nodeTravel(root, 0, targetSum, hm);
    }
    
    public int nodeTravel(TreeNode node, long sum, long targetSum, HashMap<Long, Integer> hm)
    {
        if(node == null)
        {
            return 0;
        }
        
        int ans = 0;
        if(hm.containsKey((sum+node.val) - targetSum))
        {
            ans += hm.get((sum+node.val) - targetSum);
        }
        
        if(!hm.containsKey(sum+node.val))
        {
            hm.put((sum+node.val), 1);
        }
        else
        {
            hm.put((sum+node.val), hm.get(sum+node.val) + 1);
        }
        
        ans += nodeTravel(node.left, sum+node.val, targetSum, hm);
        ans += nodeTravel(node.right, sum+node.val, targetSum, hm);
        
        if(hm.get(sum+node.val) == 1)
        {
            hm.remove(sum+node.val);
        }
        else
        {
            hm.put((sum+node.val), hm.get(sum+node.val)-1);
        }
        return ans;
    }
}