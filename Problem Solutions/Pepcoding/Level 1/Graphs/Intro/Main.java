import java.util.*;

public class Main
{
    public static class Edges{
        int src;
        int dst;
        int wt;
        
        Edges(int src, int dst, int wt)
        {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }
    
    public static void addEdge(ArrayList<Edges> graph[], int u, int v, int wt)
    {
        graph[u].add(new Edges(u,v,wt));
        graph[v].add(new Edges(v,u,wt));
    }
    
    public static void construct(int n, int noOfEdges)
    {
        Scanner scn = new Scanner(System.in);
        ArrayList<Edges> [] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < noOfEdges; i++)
        {
            System.out.print("Enter source node : ");
            int sr = scn.nextInt();
            System.out.print("Enter Destination node : ");
            int des = scn.nextInt();
            System.out.print("Enter Edge Weight : ");
            int wt = scn.nextInt();
            System.out.print("\n");
            addEdge(graph,sr,des,wt);
        }
        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 0, 3, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 2, 3, 40);
        // addEdge(graph, 3, 4, 2);
        // addEdge(graph, 4, 5, 2);
        // addEdge(graph, 5, 6, 3);
        // addEdge(graph, 4, 6, 8);
        display(graph,n);
    }
    
    public static void display(ArrayList<Edges> graph[], int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(i + " -> ");
            for(Edges edge : graph[i])
            {
                System.out.print(edge.src + " - " + edge.dst + " @ "+ edge.wt + ",");
            }
            System.out.print("\n");
        }
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		construct(n,k);
	}
}