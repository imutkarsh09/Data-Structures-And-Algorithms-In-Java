/*
-> You are given a number n, which represents the length of a road. The road has n plots on it's each side.
-> The road is to be so planned that there should not be consecutive buildings on either side of the road.
-> You are required to find and print the number of ways in which the buildings can be built on both side of roads.
*/
import java.util.*;
public class Arrange_Building 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dpb = new int[n+1];
        int[] dps = new int[n+1];
        dpb[1]=1;
        dps[1]=1;
        for(int i=2;i<=n;i++)
        {
            dpb[i]=dps[i-1];
            dps[i]=dps[i-1]+dpb[i-1];
        }
        long tot = dps[n]+dpb[n];
        tot=tot*tot;
        System.out.println(tot);
    }   
}
