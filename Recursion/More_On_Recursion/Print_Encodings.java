import java.io.*;
import java.util.*;

public class Print_Encodings {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        printEncodings(st,"");
    }

    public static void printEncodings(String str, String asf) {
        
        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }
        else if(str.length()==1)
        {
            char ch = str.charAt(0);
            if(ch=='0')
            {
                return;
            }
            else
            {
                int chv = ch-'0';
                char code = (char)('a'+chv-1);
                System.out.println(asf+code);
            }
        }
        else
        {
            char ch = str.charAt(0);
            String ros = str.substring(1);
            if(ch=='0')
            {
                return;
            }
            else
            {
                int chv = ch-'0';
                char code = (char)('a'+chv-1);
                printEncodings(ros, asf+code);
            }
            String ch12 = str.substring(0,2);
            String ros1 = str.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v<=26)
            {
                char code = (char)('a'+ch12v-1);
                printEncodings(ros1, asf+code);
            }
        }
    }

}