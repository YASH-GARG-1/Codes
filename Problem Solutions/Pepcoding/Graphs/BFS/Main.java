import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   static class Pair{
       int data;
       String ansSoFar;
       
       Pair(int data, String ansSoFar)
       {
           this.data = data;
           this.ansSoFar = ansSoFar;
       }
   }

    public static void bfsGraph(ArrayList<Edge>[] graph, int n, int src)
    {
        boolean visited[] = new boolean[n];
        Pair p = new Pair(src,""+src);
        Queue<Pair> que = new LinkedList<>();
        que.add(p);
        while(que.size() != 0)
        {
            Pair ele = que.remove();
            if(!visited[ele.data])
            {
                System.out.println(ele.data+"@"+ele.ansSoFar);
                visited[ele.data] = true;
                for(Edge edge : graph[ele.data])
                {
                   if(!visited[edge.nbr])
                   {
                       que.add(new Pair(edge.nbr,ele.ansSoFar+edge.nbr));
                   }
                }
            }
        }
    }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      bfsGraph(graph, vtces, src);
   }
}