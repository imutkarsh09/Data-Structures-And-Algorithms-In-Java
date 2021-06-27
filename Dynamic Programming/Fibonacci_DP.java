import java.util.*;
public class Fibonacci_DP
{
    public static int getFibo(int n, int[] qb)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        if(qb[n]!=0)
        {
            return qb[n];
        }
        int last = getFibo(n-1, qb);
        int slast = getFibo(n-2, qb);
        int num = last + slast;
        qb[n] = num;
        return num;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = getFibo(n,new int[n+1]);
        System.out.println(ans);
    }
}