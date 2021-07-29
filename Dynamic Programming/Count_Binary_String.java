import java.util.*;
public class Count_Binary_String
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dpo = new int[n+1];
        int[] dpz = new int[n+1];
        dpo[1]=1;
        dpz[1]=1;
        for(int i=2;i<=n;i++)
        {
            dpz[i] = dpo[i-1];
            dpo[i] = dpo[i-1] + dpz[i-1];
        }
        System.out.println(dpo[n]+dpz[n]);
    }   
}
