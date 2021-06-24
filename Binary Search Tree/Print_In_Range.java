import java.util.*;
public class Print_In_Range
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
    public static void pir(Node node, int r1,int r2)
    {
        if(node==null)
        {
            return;
        }
        if(r1>node.data && r2>node.data)
        {
            pir(node.right,r1,r2);
        }
        else if(r1<node.data && r2<node.data)
        {
            pir(node.left,r1,r2);
        }
        else
        {
            pir(node.left, r1,r2);
            System.out.println(node.data);
            pir(node.right,r1,r2);
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
        System.out.println("Enter d1 and d2");
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        pir(root,d1,d2);

    }
}