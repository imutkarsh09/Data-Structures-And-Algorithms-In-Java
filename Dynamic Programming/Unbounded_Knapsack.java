import java.util.*;
public class Unbounded_Knapsack 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wei = new int[n];
        for(int i=0;i<val.length;i++)
        {
            val[i] = sc.nextInt();
        }
        for(int i=0;i<wei.length;i++)
        {
            wei[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        int[] dp =new int[tar+1];
        for(int cap=1;cap<dp.length;cap++)
        {
            for(int i=0;i<n;i++)
            {
                int valu = val[i];
                int weig = wei[i];
                if(weig<=cap)
                {
                    int totCap = valu + dp[cap-weig];
                    dp[cap] = Math.max(dp[cap],totCap);
                }
            }
        }
        System.out.println(dp[tar]);
    }   
}
