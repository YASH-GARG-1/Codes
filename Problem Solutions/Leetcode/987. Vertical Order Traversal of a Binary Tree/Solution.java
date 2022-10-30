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
        
            if(this.level == comparePair.level)
            {
                return this.node.val - comparePair.node.val;
            }
            else
            {
                return this.level - comparePair.level;
            }
            
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int min, max;
        min = max = 0;
        HashMap<Integer, List<Pair>> hm = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        
        que.add(new Pair(0,0,root));
        
        while(que.size() > 0)
        {
            Pair temp = que.remove();
            
            int lisNo = temp.pos;
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
                
            if(temp.pos < min)
            {
                min = temp.pos;
            }
            else if(temp.pos > max)
            {
                max = temp.pos;
            }
            
            if(temp.node.left != null)
            {
                que.add(new Pair(temp.level + 1, temp.pos-1, temp.node.left));                           }
            if(temp.node.right != null)
            {
                que.add(new Pair(temp.level + 1, temp.pos+1, temp.node.right));
            }
        }
        
        for(int i = min; i <= max; i++)
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