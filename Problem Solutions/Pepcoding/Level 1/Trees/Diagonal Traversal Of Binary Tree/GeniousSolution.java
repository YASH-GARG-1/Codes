public ArrayList<Integer> diagonal(Node root)
    {

        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Node>q=new ArrayDeque<>();
           q.add(root);

           while(q.size()>0)

           {

               root=q.poll();

                while(root!=null)

               {

                   ans.add(root.data);

                   if(root.left!=null)

                   {

                       q.add(root.left);

                   }

                   root=root.right;

               }

           }
        return ans;
    }