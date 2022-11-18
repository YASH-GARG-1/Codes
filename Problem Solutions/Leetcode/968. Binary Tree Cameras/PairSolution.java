class Solution {
    
    final int notCovered = 0;
    final int covered = 1;
    final int camera = 2;
    
    public class Pair
    {
        int state;
        int count;
        
        public Pair()
        {
            state = 1;
            count = 0;
        }
    }
    
    int count = 0;
    public int minCameraCover(TreeNode root) {
        
        Pair ans = calFun(root);
        if(ans.state == notCovered)
        {
            ans.count += 1;
        }
        return ans.count;
    }
    
    public Pair calFun(TreeNode node)
    {
       if(node == null)
       {
           return new Pair();
       }
        
        Pair ans = new Pair();
        Pair left = calFun(node.left);
        Pair right = calFun(node.right);
        
        if(left.state == notCovered || right.state == notCovered)
        {
            ans.state = camera;
            ans.count = left.count + right.count + 1;
        }
        else if(right.state == camera || left.state == camera)
        {
            ans.state = covered;
            ans.count = left.count + right.count;
        }
        else
        {
            ans.state = notCovered;
            ans.count = left.count + right.count;
        }
        return ans;
    }
}
