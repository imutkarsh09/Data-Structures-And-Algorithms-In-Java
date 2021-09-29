/*
Prim's Algorithm is used to find Minimum Spanning Tree.
Minimum Spanning Tree(MST)--->

    1 - It is a subgraph of a graph.
    2 - It is a special type of subgraph which is connected as well as acyclic.
    3 - It is minimum across all the spanning(all vertices are included in spanning tree) trees.


*/




import java.util.*;

import java.io.*;
public class Prims_Algorithm 
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
    public static class Pair implements Comparable<Pair>
    {
        int v;
        int av;
        int wt;
        Pair(int v, int av, int wt)
        {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }
        public int compareTo(Pair obj)
        {
            return (this.wt-obj.wt);
        }
    }
    public static void main(String Args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0;i<vtces;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
         }
         PriorityQueue<Pair> pq = new PriorityQueue<>();
         boolean[] visited = new boolean[vtces];
         pq.add(new Pair(0,-1,0));
         while(!pq.isEmpty())
         {
             Pair rem = pq.remove();
             if(visited[rem.v]==true)
             {
                 continue;
             }
             visited[rem.v]=true;
             if(rem.av!=-1)
             {
                System.out.println("["+rem.v+"-"+rem.av+"@"+rem.wt+"]");
             }
             for(Edge edge:graph[rem.v])
             {
                 if(visited[edge.nbr]==false)
                 {
                     pq.add(new Pair(edge.nbr,rem.v,edge.wt));
                 }
             }
         }
    }
}
