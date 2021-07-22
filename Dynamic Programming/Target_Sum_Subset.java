import java.util.*;
public class Target_Sum_Subset 
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
        System.out.println("Enter Target : ");
        int tar = sc.nextInt();
        boolean[][] dp = new boolean[n+1][tar+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j]= false;
                }
                else if(j==0)
                {
                    dp[i][j] = true;
                }
                else
                {
                    if(dp[i-1][j]==true)
                    {
                        dp[i][j] = true;
                    }
                    else
                    {
                        int req = Ar[i-1];
                        if(j>=req)
                        {
                            if(dp[i-1][j-req]==true)
                            {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
    }   
}
