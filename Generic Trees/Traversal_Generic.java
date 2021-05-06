import java.util.*;
public class Traversal_Generic
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void traversals(Node node)
    {
        //Euler's left on the way deep in recursion, node's pre area
        System.out.println("Node Pre "+node.data);
        for(Node child: node.children)
        {
            //Edge Pre
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            //Edge Post
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }

        //Euler's right on the way out in recursion, node's post area
        System.out.println("Node Post "+node.data);
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] =sc.nextInt();
        }
        Stack<Node> st = new Stack<>();
        Node root=null;
        for(int i=0;i<Ar.length;i++)
        {
            if(Ar[i]==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data=Ar[i];
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
        traversals(root);
    }
}