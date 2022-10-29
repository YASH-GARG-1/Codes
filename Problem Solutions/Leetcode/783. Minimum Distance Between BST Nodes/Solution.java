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
    
    class Node
    {
        int data;
        Node next;
        Node end;
        
        Node(int data)
        {
            this.data = data;
            this.next =  null;
            this.end = null;
        }
    }
    public int minDiffInBST(TreeNode root) {
        Node lis = inOrder(root);
        int prev = lis.data;
        lis = lis.next;
        int diff = Integer.MAX_VALUE;
        // System.out.print(prev + " ");
        while(lis != null)
        {
            // System.out.print(lis.data + " ");
            if((lis.data - prev) < diff)
            {
                diff = lis.data - prev;
            }
            prev = lis.data;
            lis = lis.next;
        }
        
        return diff;
    }
    
    public Node inOrder(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        Node leftList = inOrder(root.left);
        Node temp = new Node(root.val);
        if(leftList != null)
        {
            if(leftList.end != null)
            {
                leftList.end.next = temp;
            }
            else
            {
                leftList.next = temp;
            }
            temp.end = temp;
            leftList.end = temp;
        }
        else
        {
            leftList = temp;
            temp.end = temp;
        }
        Node rightList = inOrder(root.right);
        if(rightList != null)
        {
            leftList.end.next = rightList;
            leftList.end.end = rightList.end;
            leftList.end = rightList.end;
        }
        
        return leftList;
    }
    
    // public int minDiffInBST(TreeNode root) {
    //     List<Integer> lis = inOrder(root);
    //     int diff = Integer.MAX_VALUE;
    //     for(int i = 1; i < lis.size(); i++)
    //     {
    //         int difVal = lis.get(i) - lis.get(i-1);
    //         if(difVal < diff)
    //         {
    //             diff = difVal;
    //         }
    //     }
    //     return diff;
    // }
    
//     public List<Integer> inOrder(TreeNode root)
//     {
//         if(root == null)
//         {
//             return new ArrayList<>();
//         }
//         List<Integer> leftList = inOrder(root.left);
//         leftList.add(root.val);
//         List<Integer> rightList = inOrder(root.right);
//         for(Integer ele : rightList)
//         {
//             leftList.add(ele);
//         }
        
//         return leftList;
//     }

//     public int minDiffInBST(TreeNode node) {
//          int diff = Integer.MAX_VALUE;
//         if(node == null)
//             return diff;
//         Stack<TreeNode> stk = new Stack();
//         TreeNode prev = null;
//         while(!stk.isEmpty() || node != null){
//             while(node != null){
//                 stk.push(node);
//                 node = node.left;
//             }
//             TreeNode popped = stk.pop();
//             if(prev != null){
//                diff = Math.min(diff, popped.val-prev.val); 
//             }
//             prev = popped;
//             node = popped.right;
//         }
//         return diff;
        
//     }
}