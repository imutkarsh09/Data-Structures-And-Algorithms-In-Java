import java.util.*;
public class Node_To_Root_Path
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static ArrayList<Integer> nodeToRootPath(Node node, int data)
    {
        if(node.data==data)
        {
            ArrayList<Integer> li = new ArrayList<>();
            li.add(node.data);
            return li;
        }
        for(Node child:node.children)
        {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if(ptc.size()>0)
            {
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        System.out.println("Enter the node to be searched...");
        int data = sc.nextInt();
        Stack<Node> st = new Stack<>();
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
        ArrayList<Integer> ans = new ArrayList<>();
        ans= nodeToRootPath(root, data);
        System.out.println(ans);
    }
}