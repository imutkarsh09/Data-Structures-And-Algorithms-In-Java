import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Count_Island 
{

    public static void findIsland(int[][] arr, int i, int j, boolean[][] visited)
    {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || visited[i][j]==true || arr[i][j]==1)
        {
            return;
        }
        visited[i][j]=true;
        findIsland(arr, i-1, j, visited);
        findIsland(arr, i+1, j, visited);
        findIsland(arr, i, j-1, visited);
        findIsland(arr, i, j+1, visited);
    }
    public static void main(String Args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            String parts = br.readLine();
            for(int j = 0;j<n;j++)
            {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int cnt = 0;
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0;j<arr[0].length;j++)
            {
                if(arr[i][j]==0 && visited[i][j]==false)
                {
                    cnt++;
                    findIsland(arr,i,j,visited);
                }
            }
        }
        System.out.print(cnt);
    }
}
