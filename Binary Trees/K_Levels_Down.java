import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class K_Levels_Down
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left,Node right)
        {
            this.data=data;
            this.left = left;
            this.right =right;
        }
    }
    public static class Pair
    {
        Node node;
        int state;
        Pair(Node node, int state)
        {
            this.node=node;
            this.state = state;
        }
    }
    public static Node construct(int[] Ar)
    {
        Node root = new Node(Ar[0],null,null);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx=0;
        while(st.size()>0)
        {
            Pair top = st.peek();
            if(top.state==1)
            {
                idx++;
                if(Ar[idx]!=-1)
                {
                    Node ln = new Node(Ar[idx], null,null);
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
    public static void printKLevelsDown(Node node,int k)
    {
        if(node==null || k<0)
        {
            return;
        }
        if(k==0)
        {
            System.out.print(node.data+" ");
        }
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
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
        Node root=construct(Ar);
        System.out.println("Enter The Value Of K");
        int k = sc.nextInt();
        printKLevelsDown(root,k);
    }
}