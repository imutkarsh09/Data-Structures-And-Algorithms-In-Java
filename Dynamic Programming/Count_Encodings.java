/*
We are given a string str of digits. (will never start with a 0)
We are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
We were required to calculate and print the count of encodings for the string str.
*/
import java.util.*;
public class Count_Encodings 
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for(int i=1;i<str.length();i++)
        {
            char ch = str.charAt(i);
            char lch = str.charAt(i-1);
            if(lch=='0' && ch=='0')
            {
                dp[i]=0;
            }
            else if(lch=='0' && ch!='0')
            {
                dp[i] = dp[i-1];
            }
            else if(lch!='0' && ch=='0')
            {
                if(lch=='1' || lch=='2')
                {
                    dp[i] = (i>1)?dp[i-2]:1;
                }
                else
                {
                    dp[i] = 0;
                }
            }
            else
            {
                if(Integer.parseInt(str.substring(i-1,i+1))<=26)
                {
                    dp[i] = dp[i-1] + ((i>1)?dp[i-2]:1);
                }
                else
                {
                    dp[i] = dp[i-1];
                }
            }
        }
        System.out.println(dp[str.length()-1]);
    }   
}