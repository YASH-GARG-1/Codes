import java.util.*;

public class Main{

    public static class Pair{
        Integer data;
        int state;

        Pair(){}
        Pair(Integer data)
        {
            this.data = data;
        }
        Pair(Integer data, int state)
        {
            this.data = data;
            this.state = state;
        }
    }
    
    public static class Node{

        int data;
        Node left;
        Node right;

        Node(){}

        Node(int data){    
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

    public static void main(String args[])
    {
        Integer data[] = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,  null, 70, null, null, 87, null, null};
        Pair pairRoot = new Pair(data[0],1);
        Stack<Pair> st = new Stack<>();
        st.push(pairRoot);
        int idx = 1;
        while(st.size() != 0)
        {

        }
    }
}