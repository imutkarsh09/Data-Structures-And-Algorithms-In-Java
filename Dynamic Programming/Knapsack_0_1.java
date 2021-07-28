import java.util.*;
public class Knapsack_0_1 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wei = new int[n];
        for(int i=0;i<n;i++)
        {
            val[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            wei[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int[][] dp = new int[n+1][tar+1];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                int valu = val[i-1];
                int weig = wei[i-1];
                if(j<weig)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    int op1 = dp[i-1][j];
                    int op2 = valu + dp[i-1][j-weig];
                    dp[i][j] = Math.max(op1,op2);
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
        {
            maxi = Math.max(maxi,dp[i][tar]);
        }
        System.out.println(maxi);
    }   
}
