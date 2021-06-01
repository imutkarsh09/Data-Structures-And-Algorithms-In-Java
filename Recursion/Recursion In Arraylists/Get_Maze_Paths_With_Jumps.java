import java.util.*;
public class Get_Maze_Paths_With_Jumps
{

    public static ArrayList<String> getMazePaths(int sr,int sc,int dr, int dc)
    {
        if(sr==dr && sc==dc)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        // Horizontal Paths

        for(int ms =1;ms<=dc-sc;ms++)
        {
            ArrayList<String> hpaths = getMazePaths(sr, sc+ms, dr, dc);
            for(String st:hpaths)
            {
                paths.add("h"+ms+st);
            }
        }
        // Vertical Paths

        for(int ms=1;ms<=dr-sr;ms++)
        {
            ArrayList<String> vpaths = getMazePaths(sr+ms,sc,dr,dc);
            for(String st:vpaths)
            {
                paths.add("v"+ms+st);
            }
        }
        // Diagonal Paths

        for(int ms=1;ms<=dc-sc && ms<=dr-sr;ms++)
    {
        ArrayList<String> dpaths = getMazePaths(sr+ms, sc+ms, dr, dc);
        for(String st:dpaths)
        {
            paths.add("d"+ms+st);
        }
    }
    return paths;
}
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<String> ans = getMazePaths(1,1,n,m);
        System.out.println(ans);
    }
}