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
    
    class Pair implements Comparable<Pair>{
        int level;
        int pos;
        TreeNode node;
        
        Pair(int level, int pos, TreeNode node)
        {
            this.level = level;
            this.pos = pos;
            this.node = node;
        }
        
        @Override public int compareTo(Pair comparePair) {
        
            if(this.pos == comparePair.pos)
            {
                return this.node.val - comparePair.node.val;
            }
            else
            {
                return this.pos - comparePair.pos;
            }
            
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int max = 0;
        HashMap<Integer, List<Pair>> hm = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        
        que.add(new Pair(0,0,root));
        
        while(que.size() > 0)
        {
            Pair temp = que.remove();
            
            int lisNo = temp.level;
            if(!hm.containsKey(lisNo))
            {
                List<Pair> lis = new ArrayList<>();
                lis.add(temp);
                hm.put(lisNo, lis);
            }
            else
            {
                List<Pair> lis = hm.get(lisNo);
                lis.add(temp);
                hm.put(lisNo, lis);
            }
                
            if(temp.level > max)
            {
                max = temp.level;
            }
            if(temp.node.left != null)
            {
                que.add(new Pair(temp.level + 1, temp.pos-1, temp.node.left));                           }
            if(temp.node.right != null)
            {
                que.add(new Pair(temp.level, temp.pos+1, temp.node.right));
            }
        }
        
        for(int i = 0; i <= max; i++)
        {
            List<Pair> arr= hm.get(i);
            Collections.sort(arr);
            
            List<Integer> eleLis = new ArrayList<>();
            for(Pair ele : arr)
            {
                eleLis.add(ele.node.val);
            }
            
            ans.add(eleLis);
        }
        return ans;
    }
}