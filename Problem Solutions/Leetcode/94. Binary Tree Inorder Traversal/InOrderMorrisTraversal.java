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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> retVal = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null)
        {
            if(curr.left == null)
            {
                retVal.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr)
                {
                    iop = iop.right;
                }
                if(iop.right == null)
                {
                    iop.right = curr;
                    curr = curr.left;
                }
                else
                {
                    iop.right = null;
                    retVal.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return retVal;
//         if(root == null)
//         {
//             return new ArrayList<>();
//         }
        
//         List<Integer> leftList = inorderTraversal(root.left);
        
//         leftList.add(root.val);
        
//         List<Integer> rightList = inorderTraversal(root.right);
        
//         for(Integer ele : rightList)
//         {
//             leftList.add(ele);
//         }
        
//         return leftList;
    }
}