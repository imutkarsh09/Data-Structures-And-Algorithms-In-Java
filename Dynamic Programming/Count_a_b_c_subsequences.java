/* 
We are given a string str.
We required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
*/
import java.util.*;
public class Count_a_b_c_subsequences
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int a = 0;
        int ab = 0;
        int abc = 0;
        for(int i=0;i<st.length();i++)
        {
            char ch = st.charAt(i);
            if(ch=='a')
            {
                a = 2*a+1;
            }
            else if(ch=='b')
            {
                ab = 2*ab+a;
            }
            else if(ch=='c')
            {
                abc = 2*abc + ab;
            }
        }
        System.out.println(abc);
    }
}