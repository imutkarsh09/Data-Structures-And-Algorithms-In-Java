import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Connected_Components 
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

    public static void getConnected(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> li)
    {
        visited[src] = true;
        li.add(src);
        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr]==false)
            {
                getConnected(graph, edge.nbr, visited, li);
            }
        }
    }
    public static void main(String Args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for(int i=0;i<edges;i++)
        {
            String[] st = br.readLine().split(" ");
            int v1 = Integer.parseInt(st[0]);
            int v2 = Integer.parseInt(st[1]);
            int wt = Integer.parseInt(st[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt)); 
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for(int i=0;i<vtces;i++)
        {
            if(visited[i]==false)
            {
                ArrayList<Integer> li = new ArrayList<>();
                getConnected(graph,i,visited,li);
                ans.add(li);
            }
        }
        System.out.println(ans);
    }
}
