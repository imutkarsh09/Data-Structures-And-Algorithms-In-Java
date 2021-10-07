/*
We are give a number of boxes (nboxes) and number of identical items (ritems).
We are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'.
Number of boxes is greater than number of items, hence some of the boxes may remain empty.
*/


import java.util.*;
public class Combinations1
{

    public static void getCombinations(int cb, int tb, int ssf,int ts, String asf)
    {
        if(cb>tb)
        {
            if(ssf==ts)
            {
                System.out.println(asf);
            }
            return;
        }
        getCombinations(cb+1,tb,ssf+1,ts,asf+"i");
        getCombinations(cb+1,tb,ssf,ts,asf+"-");
    }
    public static void main(String[] Args)
    {
        Scanner sc = new Scanner(System.in);
        int nboxes = sc.nextInt();
        int rboxes = sc.nextInt();
        getCombinations(1,nboxes,0,rboxes,"");
    }
}