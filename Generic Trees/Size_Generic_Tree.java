import java.util.*;
public class Size_Generic_Tree
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int size(Node node)
    {
        int s = 0;
        for(Node child: node.children)
        {
            int cs = size(child);
            s+=cs;
        }
        s=s+1;
        return s;
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
        Stack<Node> st = new Stack<>();
        Node root= null; 
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

        int si = size(root);
        System.out.println(si);
    }
}