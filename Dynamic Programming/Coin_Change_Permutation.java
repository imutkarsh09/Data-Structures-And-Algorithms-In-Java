import java.util.*;
public class Coin_Change_Permutation
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++)
        {
            coins[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int[] dp = new int[tar+1];
        dp[0]=1;
        for(int amt=1;amt<=tar;amt++)
        {
            for(int coin:coins)
            {
                if(coin<=amt)
                {
                    int rem = amt-coin;
                    dp[amt] += dp[rem];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}