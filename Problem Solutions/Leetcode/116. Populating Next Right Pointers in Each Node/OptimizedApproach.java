class Solution {
    public Node connect(Node root) {
        if(root == null)
        {
            return null;
        }
        Node temp, node;
        temp = root;
        while(temp.left != null)
        {
            node = temp;
            while(node != null)
            {
                if(node.left != null)
                {
                    node.left.next = node.right;
                    if(node.next != null)
                    {
                        node.right.next = node.next.left;
                    }
                }
                node = node.next;
            }
            temp = temp.left;
        }
        return root;
    }
    
}