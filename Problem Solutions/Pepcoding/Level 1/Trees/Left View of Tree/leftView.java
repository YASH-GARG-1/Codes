public class leftView {
    
    public class Node{
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

    public static void main(String [] args)
    {
        Scanner scn = new Scanner(System.in);
        
        scn.close();
    }
}
