import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class Size_Sum_Max_Height
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data = data;
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
        int idx = 0;
        while(st.size()>0)
        {
            Pair top = st.peek();
            if(top.state==1)
            {
                idx++;
                if(Ar[idx]!=-1)
                {
                    Node ln = new Node(Ar[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }
                else
                {
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state==2)
            {
                idx++;
                if(Ar[idx]!=-1)
                {
                    Node rn = new Node(Ar[idx],null,null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn,1);
                    st.push(rp);
                }
                else
                {
                    top.node.right = null;
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
    public static int size(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls+rs+1;
        return ts;
    }
    public static int sum(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int lsu = sum(node.left);
        int rsu = sum(node.right);
        int tsu = lsu+rsu+node.data;
        return tsu;
    }
    public static int height(Node node)
    {
        if(node == null)
        {
            return -1;// Return -1 for edges and 0 for nodes.
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh,rh)+1;
        return th;
    }
    public static int max(Node node)
    {
        if(node==null)
        {
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);
        int maxi = Math.max(Math.max(lm,rm),node.data);
        return maxi;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Node root = construct(Ar);
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int height = height(root);
        System.out.println("Size : "+size);
        System.out.println("Sum : "+sum);
        System.out.println("Max : "+max);
        System.out.println("Height : "+height);

    }
}