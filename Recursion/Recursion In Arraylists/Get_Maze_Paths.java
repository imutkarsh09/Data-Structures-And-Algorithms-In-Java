import java.util.*;
public class Get_Maze_Paths
{

    public static ArrayList<String> getMazePaths(int sr,int sc, int dr, int dc)
    {

        if(sr==dr && sc ==dc)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        if(sc<dc)
        {
            hpaths = getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr<dr)
        {
            vpaths = getMazePaths(sr+1, sc, dr, dc);
        }
        for(String st : hpaths)
        {
            paths.add("h"+st);
        }
        for(String st : vpaths)
        {
            paths.add("v"+st);
        }
        return paths;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> ans = getMazePaths(1,1,n,m);
        System.out.println(ans);
    }
} 