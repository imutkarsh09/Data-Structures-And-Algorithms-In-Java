import java.util.*;
public class Target_Sum_Subset
{
    public static void printTargetSubsets(int[] Ar,int idx, String set, int sos, int tar)
    {
        if(sos>tar)
        {
            return;
        }
        if(idx==Ar.length)
        {
            if(sos==tar)
            {
                System.out.println(set+".");
            }
            return;
        }
        printTargetSubsets(Ar, idx+1, set+Ar[idx]+" ,", sos+Ar[idx], tar);
        printTargetSubsets(Ar, idx+1, set, sos, tar);
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        printTargetSubsets(Ar, 0,"",0,tar);
    }
}