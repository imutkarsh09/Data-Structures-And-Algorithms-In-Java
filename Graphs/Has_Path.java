import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Has_Path
{
    public static class Edge
    {
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt)
        {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean hasPath(List<Edge>[] graph, int src, int des, boolean[] visited)
    {
        if(src==des)
        {
            return true;
        }
        visited[src] = true;
        for(Edge edge: graph[src])
        {
            if(visited[edge.nbr]==false)
            {
                boolean isPath = hasPath(graph, edge.nbr, des, visited);
                if(isPath)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String Args[]) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int vtces = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[vtces];
        int edges = Integer.parseInt(br.readLine());
        for(int i=0;i<vtces;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges;i++)
        {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        boolean ans = hasPath(graph,src,dest,visited);
        System.out.println(ans);

    }
}