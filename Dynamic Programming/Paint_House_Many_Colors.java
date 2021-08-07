/*
We are given a number n and a number k separated by a space, representing the number of houses and number of colors.
 In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
We are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
*/

import java.util.*;
public class Paint_House_Many_Colors {

    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        
        int[][] Ar = new int[n][c];
        for(int i = 0;i<n;i++)
        {
            for(int j =0;j<c;j++)
            {
                Ar[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][c];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int i=0;i<Ar[0].length;i++)
        {
            dp[0][i] = Ar[0][i];
            if(dp[0][i]<=least)
            {
                sleast = least;
                least = dp[0][i];
            }
            else if(dp[0][i]<=sleast)
            {
                sleast = dp[0][i];
            }
        }
        for(int i = 1;i<Ar.length;i++)
        {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for(int j = 0;j<Ar[0].length;j++)
            {
                if(dp[i-1][j] == least)
                {
                    dp[i][j] = sleast + Ar[i][j];
                }
                else
                {
                    dp[i][j] = least + Ar[i][j];
                }
                if(dp[i][j]<nleast)
                {
                    nsleast = nleast;
                    nleast = dp[i][j];
                }
                else if(dp[i][j]<nsleast)
                {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        System.out.println(least);
    }
}
