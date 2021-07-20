/*
1 - We were given two numbers n and m representing the number of rows and columns
    of our matrix respectively.
2 - Then we are given n*m numbers, representing elements of 2d array a, which represents a maze.
3 - We are standing at Ar[0][0] and is required to reach position Ar[n-1][m-1].
4 - We are only allowed to make horizonal and vertical moves on 1 each.
5 - Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
6 - We are required to traverse through the matrix and print the cost of path which is least costly.
 */
import java.util.*;
public class Min_Cost_Maze
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
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
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(i==n-1 && j==m-1)
                {
                    dp[i][j]= Ar[i][j];
                }
                else if(i==n-1)
                {
                    dp[i][j] = dp[i][j+1]+Ar[i][j];
                }
                else if(j==m-1)
                {
                    dp[i][j] = dp[i+1][j] + Ar[i][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+Ar[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}