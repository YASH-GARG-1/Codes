class Solution
{
    static class Pair{
        int pos;
        Node node;
        
        Pair(int pos, Node node)
        {
            this.pos = pos;
            this.node = node;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int min,max;
        min = max = 0;
        que.add(new Pair(0, root));
        
        while(que.size() > 0)
        {
            Pair temp = que.remove();
            hm.put(temp.pos,temp.node);
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
                que.add(new Pair((temp.pos-1), temp.node.left));
            }
            if(temp.node.right != null)
            {
                que.add(new Pair((temp.pos+1), temp.node.right));
            }
        }
        
        for(int i = min; i <= max; i++)
        {
            Node temp = hm.get(i);
            ans.add(temp.data);
        }
        
        return ans;
    }
}