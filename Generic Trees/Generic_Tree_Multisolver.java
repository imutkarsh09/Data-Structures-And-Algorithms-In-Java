import java.util.*;
public class Generic_Tree_Multisolver
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node construct(int[] Ar)
    {
        Stack<Node> st = new Stack<>();
        Node root=null;
        for(int i: Ar)
        {
            if(i==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data=i;
                if(st.size()==0)
                {
                    root=t;
                }
                else
                {
                    st.peek().children.add(t);
                }
                st.push(t);
            }
        }
        return root;
    }
    static int size;
    static int min;
    static int max;
    static int height;
    public static void multisolver(Node node, int depth)
    {
        size++;
        min=Math.min(node.data,min);
        max=Math.max(node.data,max);
        height = Math.max(height,depth);
        for(Node child:node.children)
        {
            multisolver(child,depth+1);
        }
    }
    public static void display(Node node)
    {
        String st=node.data+" -> ";
        for(Node child:node.children)
        {
            st=st+child.data+" , ";
        }
        st=st+" .";
        System.out.println(st);
        for(Node child:node.children)
        {
            display(child);
        }
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] Ar =  new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]= sc.nextInt();
        }
        Node n1 = construct(Ar);
        size=0;
        min=Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height=0;
        multisolver(n1,0);
        System.out.println("Size : "+size);
        System.out.println("Maximum : "+max);
        System.out.println("Minimum : "+min);
        System.out.println("Height : "+height);
    }
}