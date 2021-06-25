import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class Target_Sum_Pair
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data= data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair
    {
        Node node;
        int state;
        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(int[] Ar)
    {
        Node root = new Node(Ar[0], null,null);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int ind=0;
        while(st.size()>0)
        {
            Pair top = st.peek();
            if(top.state==1)
            {
                ind++;
                if(Ar[ind]!=-1)
                {
                    Node ln = new Node(Ar[ind],null,null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }
                else
                {
                    top.node.left=null;
                }
                top.state++;
            }
            else if(top.state==2)
            {
                ind++;
                if(Ar[ind]!=-1)
                {
                    Node rn = new Node(Ar[ind],null,null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn,1);
                    st.push(rp);
                }
                else
                {
                    top.node.right=null;
                }
                top.state++;
            }
            else
            {
                st.pop();
            }
        }
        return root;
    }
    public static boolean find(Node node, int data)
    {
        if(node==null)
        {
            return false;
        }
        if(data>node.data)
        {
            return find(node.right, data);
        }
        else if(data<node.data)
        {
            return find(node.left,data);
        }
        else
        {
            return true;
        }
    }
    public static void printTarget(Node root, Node node,int tar)
    {
        if(node == null)
        {
            return;
        }
        printTarget(root, node.left, tar);
        int comp = tar - node.data;
        if(node.data<comp)
        {
            if(find(root,comp))
            {
                System.out.println(node.data+" "+comp);
            }
        }
        printTarget(root, node.right, tar);
    }
    public static void main(String[] Args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Node root = construct(Ar);
        System.out.println("Enter Target : ");
        int data = sc.nextInt();
        printTarget(root,root,data);

    }
}