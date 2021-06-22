import java.util.*;
public class Size_Sum_Min_Max
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
    public static int sum(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts =ls + rs + node.data;
        return ts;
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
    public static int min(Node node)
    {
        if(node.left!=null)
        {
            return min(node.left);
        }
        else
        {
            return node.data;
        }
    }
    public static int max(Node node)
    {
        if(node.right!=null)
        {
            return max(node.right);
        }
        else
        {
            return node.data;
        }
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
        int sum = sum(root);
        int size = size(root);
        int min = min(root);
        int max = max(root);
        System.out.println("Sum : "+sum+"\nSize : "+size+"\nMin : "+min+"\nMax : "+max);
    }
}