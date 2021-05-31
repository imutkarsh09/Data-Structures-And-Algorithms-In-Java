import java.util.*;

public class Get_Stair_Paths
{
    
    public static ArrayList<String> getStairPaths(int n)
    {
        if(n==0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if(n<0)
        {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> paths1 = getStairPaths(n-1);
        ArrayList<String> paths2 = getStairPaths(n-2);
        ArrayList<String> paths3 = getStairPaths(n-3);
        ArrayList<String> paths = new ArrayList<>();
        for(String st: paths1)
        {
            paths.add("1"+st);
        }
        for(String st:paths2)
        {
            paths.add("2"+st);
        }
        for(String st:paths3)
        {
            paths.add("3"+st);
        }
        return paths;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
    }
}