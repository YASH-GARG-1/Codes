// Geeks for geeks Optimized Solution

class Tree
{
    static int md = 0;
    static void traversal(Node root, int diag, HashMap<Integer, ArrayList<Integer>> map)
    {
        if(root == null)
        {
            return;
        }
        if(diag > md)
        {
            md = diag;
        }
        if(map.containsKey(diag) == false)
        {
            map.put(diag, new ArrayList<>());
        }
        
        map.get(diag).add(root.data);
        traversal(root.left, diag+1, map);
        traversal(root.right, diag, map);
    }
     public ArrayList<Integer> diagonal(Node root)
      {
          HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
          traversal(root,0,map);
           //add your code here.
           ArrayList<Integer> ans = new ArrayList<>();
           for(int i = 0; i <= md; i++)
           {
               ArrayList<Integer> list = map.get(i);
               if(list == null)
               {
                   continue;
               }
               for(Integer ele : list)
               {
                   ans.add(ele);
               }
           }
           return ans;
      }
}
