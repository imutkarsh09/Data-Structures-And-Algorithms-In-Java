import java.util.*;

import javax.swing.text.AsyncBoxView.ChildLocator;
public class Maximum_In_Generic
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static int max(Node node)
    {
        int maxi = Integer.MIN_VALUE;
        for(Node child:node.children)
        {
            int cm = max(child);
            maxi = Math.max(cm,maxi);
        }
        maxi=Math.max(node.data,maxi);
        return maxi;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] Ar =  new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Stack<Node> st = new Stack<>();
        Node root=null;
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
                if(st.size()==0)
                {
                    root = t;
                }
                else
                {
                    st.peek().children.add(t);
                }
                st.push(t);
            }
        }
        int maxi = max(root);
        System.out.println(maxi);
    }
}