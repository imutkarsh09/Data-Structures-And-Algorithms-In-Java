// Symmetric tree is also a mirror tree of itself


import java.util.*;
public class Generic_Tree_Symmetric
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static boolean areMirror(Node n1, Node n2)
    {
        if(n1.children.size()!= n2.children.size())
        {
            return false;
        }
        for(int i=0;i<n1.children.size();i++)
        {
            int j=n1.children.size()-i-1;
            Node c1=n1.children.get(i);
            Node c2= n2.children.get(j);
            if(areMirror(c1,c2)==false)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isSymmetric(Node node)
    {
        boolean ans = areMirror(node,node);
        return ans;
    }
    public static Node construct(int[] Ar)
    {
        Stack<Node> st = new Stack<>();
        Node root=null;
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
        return root;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Node n1 = construct(Ar);
        boolean ans = isSymmetric(n1);
        if(ans == true)
        {
            System.out.println("Tree is symmetric");
        }
        else
        {
            System.out.println("Tree is symmetric");
        }
    }
}