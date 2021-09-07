/*
 A hamiltonian path is such which visits all vertices without visiting any twice.
 A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
 
-> You are given a graph and a src vertex.
-> You are required to find and print all hamiltonian paths and cycles starting from src.
    The cycles must end with "*" and paths with a "."
*/
import java.io.*;
import java.util.*;
public class Hamiltonion_Path_Cycle {
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

   public static void printHamiltonion(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc)
   {
       if(visited.size()==graph.length-1)
       {
           System.out.print(psf);
           boolean found = false;
           for(Edge edge:graph[src])
           {
               if(edge.nbr==osrc)
               {
                   found = true;
               }
           }
           if(found == true)
           {
               System.out.println("*");
           }
           else
           {
               System.out.println(".");
           }
           return;
       }
       visited.add(src);
       for(Edge edge:graph[src])
       {
           if(!visited.contains(edge.nbr))
           {
               printHamiltonion(graph, edge.nbr, visited, psf+edge.nbr,osrc);
           }
       }
       visited.remove(src);
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
      HashSet<Integer> visited = new HashSet<>();
      printHamiltonion(graph,src,visited,src+"",src);
   }


}