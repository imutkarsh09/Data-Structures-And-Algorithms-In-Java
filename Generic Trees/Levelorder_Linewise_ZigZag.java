import java.util.*;
public class Levelorder_Linewise_ZigZag
{
    public static class Node
    {
        int data;
        ArrayList<Node> children  = new ArrayList<>();
    }

    public static void lozz(Node node)
    {
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.add(node);
        int level = 1;
        while(ms.size()>0)
        {
            node = ms.pop();
            System.out.print(node.data+" ");
            if(level%2==1)
            {
                for(int i=0;i<node.children.size();i++)
                {
                    Node cn = node.children.get(i);
                    cs.add(cn);
                }
            }
            else
            {
                for(int i = node.children.size()-1;i>=0;i--)
                {
                    Node cn = node.children.get(i);
                    cs.add(cn);
                }
            }
            if(ms.size()==0)
            {
                ms=cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }  
    }
    public static void main(String Args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Stack<Node> st = new Stack<>();
        Node root= null;
        for(int i:Ar)
        {
            if(i==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data=i;
                if(st.size()==0)
                {
                    root=t;
                }
                else
                {
                    st.peek().children.add(t);
                }
                st.push(t);
            }
        }
        lozz(root);
    }
}