import java.util.*;
public class Is_Tree_BST
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
    public static class BSTPair
    {
        boolean isBST;
        int min;
        int max;
    }
    public static BSTPair isBST(Node node)
    {
        if(node==null)
        {
            BSTPair bp = new BSTPair();
            bp.min=Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp; 
        }
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);
        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST &&(node.data>= lp.max && node.data<=rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
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
        BSTPair ans = isBST(root);
        if(ans.isBST)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}