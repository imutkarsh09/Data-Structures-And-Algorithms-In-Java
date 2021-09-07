/*
-> We are given a number n (representing the number of students). Each student will have an id 
    from 0 to n - 1.
-> We are then given a number k (representing the number of clubs)
-> In the next k lines, two numbers are given separated by a space. The numbers are ids of 
    students belonging to same club.
-> We have to find in how many ways can we select a pair of students such that both students are 
    from different clubs.
*/
import java.io.*;
import java.util.*;

public class Perfect_Friends 
{
    public static class Edge
    {
        int src;
        int nbr;
        Edge(int src, int nbr)
        {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void getConnected(ArrayList<Edge>[] graph,int src, boolean[] visited, ArrayList<Integer> li)
    {
        visited[src] = true;
        li.add(src);
        for(Edge edge:graph[src])
        {
            if(visited[edge.nbr]==false)
            {
                getConnected(graph,edge.nbr,visited,li);
            }
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0;i<n;i++)
      {
          graph[i] = new ArrayList<>();
      }
      for(int i=0;i<k;i++)
      {
          String[] parts = br.readLine().split(" ");
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i = 0;i<n;i++)
      {
          if(visited[i]==false)
          {
              ArrayList<Integer> li = new ArrayList<>();
              getConnected(graph,i,visited,li);
              comps.add(li);
          }
      }
    //   System.out.println(comps);
      int pairs = 0;
      for(int i= 0;i<comps.size();i++)
      {
          for(int j = i+1;j<comps.size();j++)
          {
              int tot = comps.get(i).size()*comps.get(j).size();
              pairs+=tot;
          }
      }
      System.out.println(pairs);
   }

}