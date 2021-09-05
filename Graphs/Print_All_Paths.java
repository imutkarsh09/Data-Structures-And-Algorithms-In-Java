import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Print_All_Paths
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
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int des, boolean[] visited, String ptd)
    {
        if(src==des)
        {
            System.out.println(ptd);
            return;
        }
        visited[src] = true;
        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr]==false)
            {
                printAllPaths(graph,edge.nbr,des,visited,ptd+edge.nbr);
            }
        }
        visited[src] = false;
    }
    public static void main(String Args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge> [] graph = new ArrayList[vtces];
        for(int i = 0;i<vtces;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for(int i = 0;i<edges;i++)
        {
            String[] st = br.readLine().split(" ");
            int v1 = Integer.parseInt(st[0]);
            int v2 = Integer.parseInt(st[1]);
            int wt = Integer.parseInt(st[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        int src = Integer.parseInt(br.readLine());
        int des = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        String ptd = ""+src;
        printAllPaths(graph,src,des,visited,ptd);
    }
}