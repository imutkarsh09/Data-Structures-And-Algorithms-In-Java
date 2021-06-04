import java.util.*;
public class Print_Permutations
{

    public static void printPermutations(String str, String asf)
    {
        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            String lps = str.substring(0,i);
            String rps = str.substring(i+1);
            String str_here = lps+rps;
            printPermutations(str_here, asf+ch);
        }
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutations(str, "");
    }
}