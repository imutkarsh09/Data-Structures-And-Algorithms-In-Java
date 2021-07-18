import java.util.*;
public class Stair_Paths_With_Variable_Jumps
{


    public static int getPaths(int[] Ar)
    {
        int[] dp = new int[Ar.length+1];
        dp[Ar.length] = 1;
        for(int i = Ar.length-1;i>=0;i--)
        {
            for(int j=1;j<=Ar[i] && i+j<dp.length;j++)
            {
                dp[i] = dp[i] + dp[i+j];
            }
        }
        return dp[0];
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
        int ans = getPaths(Ar);
        System.out.println(ans);
    }   
}