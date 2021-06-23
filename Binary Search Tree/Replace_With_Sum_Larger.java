import java.util.*;
public class Replace_With_Sum_Larger
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
    static int sum = 0;
    public static Node replace(Node node)
    {
        if(node == null)
        {
            return null;
        }
        replace(node.right);
        int oridata = node.data;
        node.data =sum;
        sum += oridata; 
        replace(node.left);
        return node;
    }
    public static void display(Node node)
    {
        if(node==null)
        {
            return;
        }
        String st = "";
        if(node.left!=null)
        {
            st = st+node.left.data;
        }
        else
        {
            st = st+".";
        }
        st = st+" <- "+node.data+" -> ";
        if(node.right!=null)
        {
            st = st+node.right.data;
        }
        else
        {
            st = st+".";
        }
        System.out.println(st);
        display(node.left);
        display(node.right);

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
        Node rnode = replace(root);
        display(rnode);

    }
}