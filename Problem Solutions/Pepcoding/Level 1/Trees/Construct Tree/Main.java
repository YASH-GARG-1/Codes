import java.util.*;

public class Main{

    public static class Pair{
        Node node;
        int state;

        Pair(){}
        Pair(Node node)
        {
            this.node = node;
            this.state = 1;
        }
        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    
    public static class Node{

        Integer data;
        Node left;
        Node right;

        Node(){}

        Node(Integer data){    
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        Node(Integer data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void printTree(Node root)
    {
        if(root == null)
        {
            System.out.print("null ");
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String args[])
    {
        Integer data[] = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,  null, 70, null, null, 87, null, null};
        Node root = new Node(data[0]);
        Pair pairRoot = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(pairRoot);
        int idx = 1;
        while(st.size() != 0)
        {
            Pair peekpair = st.peek();
            if(peekpair.state == 1)
            {
                peekpair.state++;
                if(data[idx] != null)
                {
                    Node addNode = new Node(data[idx]);
                    peekpair.node.left = addNode;
                    st.push(new Pair(addNode,1));
                }
                idx++;
            }
            else if(peekpair.state == 2)
            {
                peekpair.state++;
                if(data[idx] != null)
                {
                    Node addNode = new Node(data[idx]);
                    peekpair.node.right = addNode;
                    st.push(new Pair(addNode,1));
                }
                idx++;
            }
            else
            {
                st.pop();
            }
        }

        printTree(root);
    }
}