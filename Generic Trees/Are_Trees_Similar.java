import java.util.*;
public class Are_Trees_Similar
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static boolean areSimilar(Node N1, Node N2)
    {
        if(N1.children.size()!= N2.children.size())
        {
            return false;
        }
        for(int i=0;i<N1.children.size();i++)
        {
            Node c1 = N1.children.get(i);
            Node c2 = N2.children.get(i);
            if(areSimilar(c1, c2)==false)
            {
                return false;
            }
        }
        return true;
    }
    public static Node construct(int[] Ar)
    {
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i :Ar)
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
        return root;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] Ar1 = new int[n1];
        for(int i=0;i<n1;i++)
        {
            Ar1[i]=sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] Ar2 = new int[n2];
        for(int i=0;i<n2;i++)
        {
            Ar2[i]=sc.nextInt();
        }
        Node N1 = construct(Ar1);
        Node N2 = construct(Ar2);
        boolean ans = areSimilar(N1,N2);
        if(ans==true)
        {
            System.out.println("Are Similar");
        }
        else
        {
            System.out.println("Are Not Similar");
        }
    }
}