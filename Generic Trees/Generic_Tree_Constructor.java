import java.util.*;
public class Generic_Tree_Constructor
{
    private static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        Node root;
        Stack<Node> st = new Stack<>();
        for(int i=0;i<Ar.length;i++)
        {
            if(Ar[i]==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data = Ar[i]; 
                if(st.size()>0)
                {
                    st.peek().children.add(t);
                    st.push(t);
                }
                else
                {
                    root = t;
                }
            }
        }
    }
}
    