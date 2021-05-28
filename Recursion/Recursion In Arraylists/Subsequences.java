import java.util.*;
public class Subsequences
{
    public static ArrayList<String> getss(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String res = str.substring(1);
        ArrayList<String> rres = getss(res);
        ArrayList<String> mres = new ArrayList<>();
        for(String st:rres)
        {
            mres.add(""+st);
        }
        for(String st:rres)
        {
            mres.add(ch+st);
        }
        return mres;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> ans = getss(str);
        System.out.println("Subsequences Are----->");
        System.out.println(ans);
    }
}