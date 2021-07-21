import java.util.*;
public class Maximum_Gold
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        int[][] Ar = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                Ar[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for(int j=m-1;j>=0;j--)
        {
            for(int i=n-1;i>=0;i--)
            {
                if(j==m-1)
                {
                    dp[i][j]=Ar[i][j];
                }
                else if (i==0)
                {
                    dp[i][j] = Ar[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }
                else if(i==n-1)
                {
                    dp[i][j] = Ar[i][j] +  Math.max(dp[i][j+1],dp[i-1][j+1]);
                }
                else
                {
                    dp[i][j] = Ar[i][j] + Math.max(Math.max(dp[i][j+1],dp[i+1][j+1]),dp[i-1][j+1]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,dp[i][0]);
        }
        System.out.println(max);
    }
}