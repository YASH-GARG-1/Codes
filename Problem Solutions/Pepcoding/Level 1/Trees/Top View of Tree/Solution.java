class TreeNode{
    int val;
    TreeNode left,right;
}

class Node
{
    int pos;
    TreeNode node;
            
    Node(int pos, TreeNode node)
    {
        this.pos = pos;
        this.node = node;
    }
}

        HashMap<Integer, TreeNode> hm = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        int min,max;
        min = max = 0;
        que.add(new Node(0,root));
        while(que.size() > 0)
        {
            Node temp = que.remove();
            if(!hm.containsKey(temp.pos))
            {
                hm.put(temp.pos,temp.node);
                // arr.add(temp.node.val);
                if(temp.pos < min)
                {
                    min = temp.pos;
                }
                else if(temp.pos > max)
                {
                    max = temp.pos;
                }
            }
            if(temp.node.left != null)
            {
                que.add(new Node((temp.pos-1), temp.node.left));
            }
            if(temp.node.right != null)
            {
                que.add(new Node((temp.pos+1), temp.node.right));
            }
        }
        
        for(int i = min; i <= max; i++)
        {
            TreeNode temp = hm.get(i);
            System.out.print(i + ":" + temp.val + " ");
        }