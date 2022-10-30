import java.io.*;
import java.util.*;

public class ReverseLevelOrder {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void levelOrder(Node node) {
    // write your code here
    
    // Stack<Node> st = new Stack<>();
    Queue<Node> que = new LinkedList<>();
    // ArrayDeque<Node> que = new ArrayDeque<>();
    // First approach is to use the stack to store each element individually.
    // Second better approach is to use a String Stack.
    // This also reduces the no. of times while loop for the stack
    // will be executed The time complexity is reduced from 
    // O(N) to O(log N) where N is the no. of nodes present in the tree.
    Stack<String> st = new Stack<>();
    String str = "";
    que.add(node);
    que.add(null);
    
    while(que.size() > 0)
    {
        Node temp = que.remove();
        if(temp == null)
        {
            st.push(str);
            str = "";
            if(que.size() > 0)
            {
                // System.out.print("\n");
                // st.push(null);
                que.add(null);
            }
        }
        else
        {
            // System.out.print(temp.data + " ");
            // st.push(temp);
            // if(temp.right != null)
            // {
            //     que.add(temp.right);
            // }
            // if(temp.left != null)
            // {
            //     que.add(temp.left);
            // }
            str = str + temp.data + " ";
            if(temp.left != null)
            {
                que.add(temp.left);
            }
            if(temp.right != null)
            {
                que.add(temp.right);
            }
        }
    }
    
    while(st.size() > 0)
    {
        // Node temp = st.pop();
        // if(temp == null)
        // {
        //     System.out.print("\n");
        // }
        // else
        // {
        //     System.out.print(temp.data + " ");
        // }
        String temp = st.pop();
        System.out.println(temp);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    levelOrder(root);
  }

}