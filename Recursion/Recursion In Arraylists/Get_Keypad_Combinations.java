import java.util.*;
public class Get_Keypad_Combinations
{

    static String[] codes = {".,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String st)
    {
        if(st.length()==0)
        {
            ArrayList<String> brem = new ArrayList<>();
            brem.add("");
            return brem; 
        }
        char ch = st.charAt(0);
        String rem = st.substring(1);
        ArrayList<String> crem = getKPC(rem);
        String codeforch = codes[ch-'0'];
        ArrayList<String> rrem = new ArrayList<>();
        for(int i=0;i<codeforch.length();i++)
        {
            char cha = codeforch.charAt(i);
            for(String strr:crem)
            {
                rrem.add(cha+strr);
            }
        }
        return rrem;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        ArrayList<String> ans = getKPC(st);
        System.out.println(ans);
    }
}