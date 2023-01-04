import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    static class Node
    {
        int val;
        Node left;
        Node right;
        Node(int val)
        {
            this.val = val;
            left = null;
            right = null;
        }
        Node(int val, Node left, Node right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Node head;

    static void createBinaryTree(Node node, int ele)
    {
        if(head == null)
        {
            Node temp = new Node(ele);
            head = temp;
            return;
        }
        if(node.val < ele)
        {
            if(node.right == null)
            {
                Node temp = new Node(ele);
                node.right = temp;
                return;
            }
            else
            {
                createBinaryTree(node.right, ele);
            }
        }
        else
        {
            if(node.left == null)
            {
                Node temp = new Node(ele);
                node.left = temp;
                return;
            }
            else
            {
                createBinaryTree(node.left, ele);
            }
        }
    } 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        head = null;
        int n = scn.nextInt();
        for(int i = 0; i < n; i++)
        {
            int ele = scn.nextInt();
            createBinaryTree(head, ele);
        }
        int min = scn.nextInt();
        int max = scn.nextInt();
        System.out.print(sumFinder(head, min, max));
        scn.close();
    }

    static int sumFinder(Node node, int min, int max)
    {
        int sum = 0;
        if(node == null)
        {
            return 0;
        }
        if(node.val > max)
        {
            sum += sumFinder(node.left, min, max);
        }
        else if(node.val < min)
        {
            sum += sumFinder(node.right, min, max);
        }
        else
        {
            sum += node.val;
            sum += sumFinder(node.left, min,max);
            sum += sumFinder(node.right, min, max);
        }
        return sum;
    }
}