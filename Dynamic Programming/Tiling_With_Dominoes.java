/*
We are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
We an infinite supply of 2 * 1 tiles.
We are required to calculate and print the number of ways floor can be tiled using tiles.
*/
import java.util.*;
public class Tiling_With_Dominoes 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<dp.length;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }   
}
