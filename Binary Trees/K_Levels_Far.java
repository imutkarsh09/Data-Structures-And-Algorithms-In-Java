import java.util.*;
public class K_Levels_Far
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
    public static void printKLevelsDown(Node node,int k, Node blocker)
    {
        if(node==null || k<0 || node==blocker)
        {
            return;
        }
        if(k==0)
        {
            System.out.print(node.data+" ");
        }
        printKLevelsDown(node.left,k-1, blocker);
        printKLevelsDown(node.right,k-1, blocker);
    }
    static ArrayList<Node> path = new ArrayList<>();
    public static boolean find(Node node, int data)
    {
        if(node==null)
        {
            return false;
        }
        if(node.data==data)
        {
            path.add(node);
            return true;
        }
        boolean nilc = find(node.left,data);
        if(nilc)
        {
            path.add(node);
            return true;
        }
        boolean nirc = find(node.right, data);
        if(nirc)
        {
            path.add(node);
            return true;
        }
        return false;
    }
    public static void printKNodesFar(Node node, int data, int k)
    {
        path = new ArrayList<>();
        find(node,data);
        for(int i=0;i<path.size();i++)
        {
            printKLevelsDown(path.get(i), k-i, i==0?null:path.get(i-1));
        }
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
        System.out.println("Please Enter Data and K");
        int data = sc.nextInt();
        int k = sc.nextInt();
        printKNodesFar(root, data, k);

    }
}