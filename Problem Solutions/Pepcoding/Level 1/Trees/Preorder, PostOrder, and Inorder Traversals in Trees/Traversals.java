import java.util.*;

public class Traversals {
    
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

    public static void preOrderTraversal(Node root)
    {
        if(root == null)
        {
            System.out.print("null ");
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root)
    {
        if(root == null)
        {
            System.out.print("null ");
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void InOrderTraversal(Node root)
    {
        if(root == null)
        {
            System.out.print("null ");
            return;
        }

        InOrderTraversal(root.left);
        System.out.print(root.data + " ");
        InOrderTraversal(root.right);
    }

    public static void printArray(int arr[], int n)
    {
        System.out.print("\n The traversal is : ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n\n");
    }
    public static void main(String [] args)
    {
        int preOrder[] = new int[9];
        int postOrder[] = new int[9];
        int InOrder[] = new int[9];
        int preIdx = 0, postIdx = 0, InIdx = 0; 
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
                preOrder[preIdx++] = peekPair.node.data;
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
                InOrder[InIdx++] = peekPair.node.data;
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
                postOrder[postIdx++] = peekPair.node.data;
                st.pop();
            }
        }
        
        System.out.print("\n Preorder Traversal : ");
        preOrderTraversal(root);
        printArray(preOrder, preIdx);
        System.out.print(" InOrder Traversal : ");
        InOrderTraversal(root);
        printArray(InOrder, InIdx);
        System.out.print(" PostOrder Traversal : ");
        postOrderTraversal(root);
        printArray(postOrder, postIdx);
    }
}