/*
We are given a number n and a number m separated by line-break representing the length and breadth of a m * n floor.
There is an infinite supply of m * 1 tiles.
We are required to calculate and print the number of ways floor can be tiled using tiles.
*/
import java.util.*;
public class Tiling_With_Dominoes_2 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n+1];
        for(int i=1;i<dp.length;i++)
        {
            if(i<m)
            {
                dp[i] = 1;
            }
            else if(i==m)
            {
                dp[i] = 2;
            }s
            else
            {
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        System.out.println(dp[n]);
    }    
}
