// Ceil is smallest among largest
// Floor is largest among smallest
import java.util.*;
public class Kth_Largest
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node construct(int[] Ar)
    {
        Stack<Node> st = new Stack<>();
        Node root= null;
        for(int i:Ar)
        {
            if(i==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data = i;
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
    public static void caf(Node root, int data)
    {
        int no = root.data;
        if(root.data>data)
        {
            if(root.data<ceil)
            {
                ceil=root.data;
            }
        }
        else if(root.data<data)
        {
            if(root.data>floor)
            {
                floor = root.data;
            }
        }
        for(Node child:root.children)
        {
            caf(child,data);
        }
    }
    public static int klar(Node node, int k)
    {
        floor = Integer.MIN_VALUE;
    int factor = Integer.MAX_VALUE;
    for(int i= 0; i<k;i++)
    {
        caf(node, factor);
        factor = floor;
        floor = Integer.MIN_VALUE;
    }
    return factor;
    }
    static int ceil;
    static int floor;
    public static void main(String Args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Node n1 = construct(Ar);
        System.out.println("Enter the value of K");
        int k = sc.nextInt();
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        int kth_Lar = klar(n1, k);
        System.out.println("Kth Largest Element is : "+kth_Lar);
    }
}