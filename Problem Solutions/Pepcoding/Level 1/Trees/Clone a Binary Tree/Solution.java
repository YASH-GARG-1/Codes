// Another Approach, without using a hashmap.

class Solution{
    public Tree cloneTree(Tree tree){
       // add code here.
    //   HashMap<Tree, Tree> hm = new HashMap<>();
    //   Tree clonetree = cloneFunction(tree, hm);
    //   cloneTreeRandomPointers(tree, clonetree, hm);
        Tree ans = updateTree(tree);
        updateRandomPointer(ans);
        return getTree(ans);
    //   return clonetree;
     }
     
     public Tree updateTree(Tree node)
     {
         if(node == null)
         {
             return null;
         }
         Tree temp = new Tree(node.data);
         temp.left = node.left;
         node.left = temp;
         temp.left = updateTree(temp.left);
         node.right = updateTree(node.right);
         return node;
     }
     
     public void updateRandomPointer(Tree node)
     {
         if(node == null)
         {
             return;
         }
         
         if(node.random != null)
            node.left.random = node.random.left;
         updateRandomPointer(node.left.left);
         updateRandomPointer(node.right);
     }
     
     public Tree getTree(Tree node)
     {
         if(node == null)
         {
             return null;
         }
         Tree temp = node.left;
         node.left = temp.left;
         temp.left = getTree(node.left);
         temp.right = getTree(node.right);
         return temp;
     }
}