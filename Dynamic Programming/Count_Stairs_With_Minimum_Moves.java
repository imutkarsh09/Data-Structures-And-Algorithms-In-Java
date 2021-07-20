import java.util.*;
public class Count_Stairs_With_Minimum_Moves
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        Integer[] dp = new Integer[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int min  =Integer.MAX_VALUE;
            if(Ar[i]!=0)
            {
                for(int j=1;j<=Ar[i] && i+j<dp.length;j++)
                {
                    if(dp[i+j]!=null)
                    {
                        min = Math.min(min,dp[i+j]);
                    }
                }
            }
            if(min!=Integer.MAX_VALUE)
            {
                dp[i]=min+1;
            }
        }

        System.out.println(dp[0]);
    }
}