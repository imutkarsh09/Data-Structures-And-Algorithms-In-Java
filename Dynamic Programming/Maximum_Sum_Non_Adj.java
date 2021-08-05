/*
We are given a number n, representing the count of elements.
We are given n numbers, representing n elements.
We are required to find the maximum sum of a subsequence with no adjacent elements.
*/
import java.util.*;
public class Maximum_Sum_Non_Adj 
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
        int[] inc = new int[n];
        int[] exc = new int[n];
        inc[0] = Ar[0];
        exc[0] = 0;
        for(int i=1;i<n;i++)
        {
            inc[i] = exc[i-1] + Ar[i];
            exc[i] = Math.max(inc[i-1],exc[i-1]);
        }
        System.out.println(Math.max(inc[n-1],exc[n-1]));
    }   
}
