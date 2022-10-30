//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    static class TreeNode
    {
        int pos;
        Node node;
            
        TreeNode(int pos, Node node)
        {
            this.pos = pos;
            this.node = node;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code

        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        int min,max;
        min = max = 0;
        que.add(new TreeNode(0,root));
        while(que.size() > 0)
        {
            TreeNode temp = que.remove();
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
                que.add(new TreeNode((temp.pos-1), temp.node.left));
            }
            if(temp.node.right != null)
            {
                que.add(new TreeNode((temp.pos+1), temp.node.right));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; i++)
        {
            Node temp = hm.get(i);
            // System.out.print(i + ":" + temp.val + " ");
            ans.add(temp.data);
        }
        
        return ans;
    }
}