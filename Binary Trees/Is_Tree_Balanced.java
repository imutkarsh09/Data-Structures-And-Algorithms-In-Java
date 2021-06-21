import java.util.*;
public class Is_Tree_Balanced
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data=data;
            this.left=left;
            this.right= right;
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
    public static class BalPair
    {
        int ht;
        boolean isBal;
    }
    public static BalPair isBal(Node node)
    {
        if(node == null)
        {
            BalPair bp = new BalPair();
            bp.isBal =true;
            bp.ht = 0;
            return bp;
        }
        BalPair lp = isBal(node.left);
        BalPair rp = isBal(node.right);
        BalPair mp = new BalPair();
        mp.ht = Math.max(lp.ht,rp.ht) +1;
        mp.isBal = lp.isBal && rp.isBal && (Math.abs(lp.ht-rp.ht)<=1);
        return mp;
    }
        public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] =sc.nextInt();
        }
        Node root = construct(Ar);
        BalPair ans = isBal(root);
        System.out.println(ans.isBal);
    }
}