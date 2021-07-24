import java.util.*;
public class Coin_Change_Combination
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
        System.out.println("Enter Amount :");
        int tar = sc.nextInt();
        int[] dp = new int[tar+1];
        dp[0]=1;
        for(int i=0;i<Ar.length;i++)
        {
            int coin = Ar[i];
            for(int j=coin;j<dp.length;j++)
            {
                dp[j] =dp[j] + dp[j-coin]; 
            }  
        }
        System.out.println("Total combinations is for amount is : "+dp[tar]);
    }
}