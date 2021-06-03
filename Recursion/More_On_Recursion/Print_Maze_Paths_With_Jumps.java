import java.util.*;
public class Print_Maze_Paths_With_Jumps
{
    public static void printPathJumps(int sr, int sc, int dr,int dc, String psf)
    {
        if(sr==dr && sc==dc)
        {
            System.out.println(psf);
            return;
        }
        for(int i=1;i<=dc-sc;i++)
        {
            printPathJumps(sr, sc+i, dr, dc, psf+"h"+i);
        }
        for(int i=1;i<=dr-sr;i++)
        {
            printPathJumps(sr+i, sc, dr, dc, psf+"v"+i);
        }
        for(int i=1;i<=dr-sr && i<=dc-sc;i++)
        {
            printPathJumps(sr+i, sc+i, dr, dc, psf+"d"+i);
        }
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printPathJumps(1,1,n,m,"");
    }
}