import java.util.*;

@SuppressWarnings("unchecked")
class TreeBias {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> [] graph =  new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++)
        {
            int src = scn.nextInt();
            int dest = scn.nextInt();
            graph[src-1].add(dest-1);
            graph[dest-1].add(src-1);
        }
        boolean [] visited = new boolean[n];
        System.out.print(findTreeBias(graph, 0, 0, visited));
        scn.close();
    }

    static int findTreeBias(ArrayList [] graph, int node, int dep, boolean[] visited)
    {
        if(visited[node])
        {
            return 0;
        }
        int sum = dep;
        visited[node] = true;
        ArrayList<Integer> arr = graph[node];
        for(int ele : arr)
        {
            if(!visited[ele])
            {
                sum += findTreeBias(graph, ele, dep+1, visited);
            }
        }
        return sum;
    }
}