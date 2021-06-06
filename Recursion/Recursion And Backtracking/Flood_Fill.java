import java.util.*;
public class Flood_Fill
{

    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited)
    {
        if(sr<0 || sc<0 || sr==maze.length || sc==maze[0].length|| maze[sr][sc]==1 || visited[sr][sc]==true)
        {
            return;
        }
        if(sr==maze.length-1 && sc== maze[0].length-1)
        {
            System.out.println(asf);
            return;
        }
        visited[sr][sc]=true;
        floodfill(maze, sr-1, sc, asf+"t", visited);
        floodfill(maze, sr, sc-1, asf+"l", visited);
        floodfill(maze, sr+1, sc, asf+"d", visited);
        floodfill(maze, sr, sc+1, asf+"r", visited);
        visited[sr][sc]=false;
    }
    public static void main(String Args[])
    {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] Ar = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                Ar[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(Ar,0,0, "", visited);
    }
}