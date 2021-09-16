/*
-> We are given a graph, representing people and their connectivity.
-> We are also given a src person (who got infected) and time t.
-> We are required to find how many people will get infected in time t,
    if the infection spreads to neighbors of infected person in 1 unit of time.
*/

import java.io.*;
import java.util.*;

public class Spread_Of_Infection 
{
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
       int time;
       Pair(int v,int time)
       {
           this.v = v;
           this.time = time;
       }
   }
   public static int getAns(ArrayList<Edge>[] graph,int src,int time)
   {
       ArrayDeque<Pair> pq = new ArrayDeque<>();
       boolean[] visited = new boolean[graph.length];
       int ans = 0;
       pq.add(new Pair(src,1));
       while(!pq.isEmpty())
       {
           Pair top = pq.removeFirst();
           if(visited[top.v]==true)
           {
               continue;
           }
           if(top.time>time)
           {
               break;
           }
           ans++;
           visited[top.v]=true;
           for(Edge edge:graph[top.v])
           {
               if(visited[edge.nbr]==false)
               {
                pq.add(new Pair(edge.nbr,top.time+1));
               }
           }
       }
       return ans;
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
      int t = Integer.parseInt(br.readLine());
      int ans = getAns(graph,src,t);
      System.out.println(ans);
   }
}