import java.util.*;

public class SpiralTraversal{
    
    public static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair
    {
        Node node;
        int state;

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

    public static void PrintSpiral(ArrayList<Integer> arrLis, int order)
    {
        if(order%2 == 0)
        {
            for(Integer ele : arrLis)
            {
                System.out.print(ele + " ");
            }
        }
        else{
            for(int i = arrLis.size()-1; i >= 0; i--)
            {
                System.out.print(arrLis.get(i) + " ");
            }
        }
    }

    public static void SpiralTraversal(Node root)
    {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int lev = 0,ord = 0;
        while(que.size() > 0)
        {
            System.out.print("Level " + lev + " : ");
            int len = que.size();
            ArrayList<Integer> arrLis = new ArrayList<>();
            while(len > 0)
            {
                Node node = que.remove();
                // System.out.print(node.data + " ");
                arrLis.add(node.data);
                if(node.left != null)
                {
                    que.add(node.left);
                }
                if(node.right != null)
                {
                    que.add(node.right);
                }
                len--;
            }
            PrintSpiral(arrLis,ord);
            ord++;
            lev++;
            System.out.print("\n");
        }
    }

    public static void main(String [] args)
    {
        Integer data[] = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,  null, 70, null, null, 87, null, null};
        Stack<Pair> st = new Stack<>();
        int idx = 1;
        Node root = new Node(data[0]);
        st.push(new Pair(root));
        while(st.size() > 0)
        {
            Pair peekPair = st.peek();
            if(peekPair.state == 1)
            {
                peekPair.state++;
                if(data[idx]!= null)
                {
                    Node addNode = new Node(data[idx]);
                    peekPair.node.left = addNode;
                    st.push(new Pair(addNode));
                }
                idx++;
            }
            else if(peekPair.state == 2)
            {
                peekPair.state++;
                if(data[idx]!= null)
                {
                    Node addNode = new Node(data[idx]);
                    peekPair.node.right = addNode;
                    st.push(new Pair(addNode));
                }
                idx++;
            }
            else
            {
                st.pop();
            }
        }
        
        System.out.print("\nSpiral Traversal is : \n");
        SpiralTraversal(root);
    }
}