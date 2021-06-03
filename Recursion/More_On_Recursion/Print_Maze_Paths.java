import java.util.*;
public class Print_Maze_Paths
{
    public static void printMazePaths(int sr, int sc, int dr, int dc,String paths)
    {
        if(sr>dr || sc>dc)
        {
            return;
        }
        if(sr==dr && sc==dc)
        {
            System.out.println(paths);
            return;
        }
        printMazePaths(sr, sc+1, dr, dc, paths+"h");
        printMazePaths(sr+1, sc, dr, dc, paths+"v");
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printMazePaths(1,1,n,m,"");
    }
}