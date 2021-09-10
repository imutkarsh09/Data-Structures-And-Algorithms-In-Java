import java.io.*;
import java.util.*;

public class Breadth_First_Traversal {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   public static class Pair
   {
       int v;
       String psf;
       Pair(int v, String psf)
       {
           this.v = v;
           this.psf = psf;
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

      // Remove Mark_Visited Work Add

      ArrayDeque<Pair> q = new ArrayDeque<>();
      boolean[] visited = new boolean[vtces]; 
      q.add(new Pair(src,src+""));
      while(!q.isEmpty())
      {
          Pair top = q.removeFirst();
          if(visited[top.v]==true)
          {
              continue;
          }
          visited[top.v] = true;
          System.out.println(top.v+"@"+top.psf);
          for(Edge edge:graph[top.v])
          {
              if(visited[edge.nbr]==false)
              {
                  q.add(new Pair(edge.nbr,top.psf+edge.nbr));
              }
          }
      }
    }
}