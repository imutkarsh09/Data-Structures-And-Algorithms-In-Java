import java.io.*;
import java.util.*;

public class Dijkstra {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static class Pair implements Comparable<Pair>
   {
       int v;
       String psf;
       int wsf;
       Pair(int v,String psf,int wsf)
       {
           this.v = v;
           this.psf = psf;
           this.wsf = wsf;
       }
       public int compareTo(Pair obj)
       {
           return (this.wsf - obj.wsf);
       }
   }
   public static void getShortestPath(ArrayList<Edge>[] graph,int src)
   {
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       boolean[] visited = new boolean[graph.length];
       pq.add(new Pair(src,src+"",0));
       while(pq.size()>0)
       {
           Pair top = pq.remove();
           if(visited[top.v]==true)
           {
               continue;
           }
           visited[top.v] = true;
           System.out.println(top.v+" via "+top.psf+" @ "+top.wsf);
           for(Edge edge:graph[top.v])
           {
               if(visited[edge.nbr]==false)
               {
                   pq.add(new Pair(edge.nbr,top.psf+edge.nbr,top.wsf+edge.wt));
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      int src = Integer.parseInt(br.readLine());
      getShortestPath(graph,src);
   }

}