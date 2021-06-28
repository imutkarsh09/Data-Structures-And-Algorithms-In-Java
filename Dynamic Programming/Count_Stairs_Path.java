import java.util.*;
public class Count_Stairs_Path
{
    public static int countPathTab(int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                dp[i]=dp[i-1];
            }
            else if(i==2)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-2]  +dp[i-3];
            }
        }
        return dp[n];
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = countPathTab(n);
        System.out.println(ans);
    }
}