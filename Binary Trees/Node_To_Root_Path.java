import java.util.*;
public class Node_To_Root_Path
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
        Node root = new Node(Ar[0],null,null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<Pair>();
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
                    top.node.left =null;
                }
                top.state++;
            }
            else if(top.state==2)
            {
                idx++;
                if(Ar[idx]!=-1)
                {
                    Node rn = new Node(Ar[idx], null, null);
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
        return  root;

    }
    static ArrayList<Integer> path = new ArrayList<>();
    public static boolean find(Node node, int data)
    {
        if(node==null)
        {
            return false;
        }
        if(node.data==data)
        {
            path.add(node.data);
            return true;
        }
        boolean filc = find(node.left,data);
        if(filc)
        {
            path.add(node.data);
            return true;
        }
        boolean firc = find(node.right, data);
        if(firc)
        {
            path.add(node.data);
            return true;
        }
        return false;
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
        System.out.println("Enter the node to be searched: ");
        int ser = sc.nextInt();
        boolean ans = find(root,ser);
        if(ans)
        {
            System.out.println("Node is present");
            System.out.println("Path Is------>");
            System.out.println(path);
        }
        else
        {
            System.out.println("Node is not present");
        }
        
    } 
}