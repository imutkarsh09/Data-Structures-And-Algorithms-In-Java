/*
We are given a number n, representing the number of houses.
In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
We are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
*/


import java.util.*;
public class Paint_House
{
    public static void main(String aString[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] Ar = new int[n][3];
        for(int i=0;i<Ar.length;i++)
        {
            for(int j=0;j<Ar[0].length;j++)
            {
                Ar[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = Ar[0][0];
        dp[0][1] = Ar[0][1];
        dp[0][2] = Ar[0][2];
        for(int i =1;i<Ar.length;i++)
        {
            dp[i][0] = Ar[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = Ar[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = Ar[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        int ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.println(ans);
    }
}
