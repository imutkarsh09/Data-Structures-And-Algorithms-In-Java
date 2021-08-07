/**
We are given a number n and a number k in separate lines, representing the number of fences and number of colors.
We are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
*/


import java.util.*;
public class Paint_Fences 
{
    public static void main(String[] Args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int same = k*1;
        int diff = k*(k-1);
        int total = same + diff;

        for(int i=3;i<=n;i++)
        {
            same = diff*1;
            diff = total*(k-1);
            total = same + diff;
        }
        System.out.println(total);
    }

}
