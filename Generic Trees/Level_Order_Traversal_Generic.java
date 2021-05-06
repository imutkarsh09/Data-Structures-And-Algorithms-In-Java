import java.util.*;
public class Level_Order_Traversal_Generic
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrder(Node node)
    {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()!=0)
        {
            node = q.remove();
            System.out.print(node.data+" ");
            for(Node child: node.children)
            {
                q.add(child);
            }
        }
        System.out.print(".");
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Stack<Node> st=new Stack<>();
        Node root = null;
        for(int i:Ar)
        {
            if(i==-1)
            {
                st.pop();
            }
            else
            {
                Node t = new Node();
                t.data =i;
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
        levelOrder(root);
    }
}