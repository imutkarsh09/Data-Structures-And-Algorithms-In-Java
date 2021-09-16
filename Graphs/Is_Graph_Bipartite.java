/* 
A Bipartite Graph is a graph if it is possible to divide vertices into two-->
  
    1 -> Mutually Exclusive (No common vertex between two sets)
    2 -> Mutually Exhaustive (Vertex in both the sets combine to form all the vertices).

Sets and all edges are across sets.

Important Points----> 

1 - Every Non Cyclic Graph is Bipartite.
2 - Every Cyclic Graph of even length is Bipartite. 
*/

import java.io.*;
import java.util.*;

public class Is_Graph_Bipartite {
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
   public static class Pair
   {
       int v;
       String psf;
       int level;
       Pair(int v,String psf,int level)
       {
           this.v = v;
           this.psf = psf;
           this.level = level;
       }
   }
   public static boolean isComponentBipartite(ArrayList<Edge>[] graph,int src,int[] visited)
   {
       ArrayDeque<Pair> pq = new ArrayDeque<>();
       pq.add(new Pair(src,src+"",0));
       while(!pq.isEmpty())
       {
           Pair rem = pq.removeFirst();
           if(visited[rem.v]!=-1)
           {
               if(visited[rem.v]!=rem.level)
               {
                   return false;
               }
           }
           else
           {
               visited[rem.v] = rem.level;
           }
           for(Edge edge:graph[rem.v])
           {
               if(visited[edge.nbr]==-1)
               {
                   pq.add(new Pair(edge.nbr,rem.psf+edge.nbr,rem.level+1));
               }
           }
       }
       return true;
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
      int[] visited = new int[vtces];
      Arrays.fill(visited,-1);
      for(int i = 0;i<vtces;i++)
      {
          if(visited[i]==-1)
          {
              boolean isVal = isComponentBipartite(graph,i,visited);
              if(!isVal)
              {
                  System.out.println("false");
                  return;
              }
          }
      }
      System.out.println("true");
   }
}
