import java.util.*;
public class Target_Pair_Sum_2
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

    public static void getList(Node node, List<Integer> li)
    {
        if(node==null)
        {
            return;
        }
        getList(node.left, li);
        li.add(node.data);
        getList(node.right, li);
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
        List<Integer> li = new ArrayList<>();
        getList(root, li);
        int l = 0;
        int r = li.size()-1;
        while(l<r)
        {
            int left = li.get(l);
            int right = li.get(r);
            if((left+right)<data)
            {
                l++;
            }
            else if((left+right)>data)
            {
                r--;
            }
            else
            {
                System.out.println(left+" "+right);
                l++;
                r--;
            }

        }

    }
}