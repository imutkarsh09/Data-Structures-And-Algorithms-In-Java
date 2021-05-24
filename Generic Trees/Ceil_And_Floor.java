// Ceil is smallest among largest
// Floor is largest among smallest
import java.util.*;
public class Ceil_And_Floor
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
        System.out.println("Enter the Node to be searched : ");
        int ser = sc.nextInt();
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        caf(n1,ser);
        System.out.println("Ceil : "+ceil+"\n"+"Floor : "+floor);
    }
}