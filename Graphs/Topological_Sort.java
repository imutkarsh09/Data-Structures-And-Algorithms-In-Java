 /*
 Topological Sort --> A permutation of vertices of a directed acyclic graph is called topological sort if in directed edge
                      (u->v), u appears before v in the graph

 Order of work is just the opposite of topological sort.
 */

import java.io.*;
import java.util.*;

public class Topological_Sort {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void toposort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st)
   {
       visited[src] = true;
       for(Edge edge:graph[src])
       {
           if(visited[edge.nbr]==false)
           {
               toposort(graph, edge.nbr, visited, st);
           }
       }
       st.push(src);
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
      }

      boolean[] visited = new boolean[vtces];
      Stack<Integer> st = new Stack<>();
      for(int v = 0;v<vtces;v++)
      {
          if(visited[v]==false)
          {
              toposort(graph,v,visited,st);
          }
      }
      while(!st.isEmpty())
      {
          System.out.println(st.pop());
      }
   }

}
