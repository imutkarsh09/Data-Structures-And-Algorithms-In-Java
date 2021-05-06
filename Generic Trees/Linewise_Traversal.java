import java.util.*;
public class Linewise_Traversal
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void linewise(Node node)
    {
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(node);
        while(mq.size()!=0)
        {
            node = mq.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children)
            {
                cq.add(child);
            }
            if(mq.size()==0)
            {
                mq=cq;
                cq=new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Stack<Node> st = new Stack<>();
        Node root= null;
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
        linewise(root);

    }
}