/*
We are given a number n, representing the number of stairs in a staircase.
In starting we are on the 0th step and are required to climb to the top.
We are given n numbers, where ith element's value represents - till how far from the step you 
    could jump to in a single move(ranging from 1 to Ar[i]).
We have to print the number of minimum moves in which you can reach the top of 
     staircase.
 */
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
