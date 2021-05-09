import java.util.*;
public class Find_In_Tree
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static boolean find(Node node, int data)
    {
        if(node.data==data)
        {
            return true;
        }
        for(Node child:node.children)
        {
            boolean pic = find(child,data);
            if(pic)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String Args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        System.out.println("Enter The Element to be found : ");
        int data = sc.nextInt();
        Stack<Node> st = new Stack<>();
        Node root=null;
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
        boolean present = find(root,data);
        if(present)
        {
            System.out.println("The Node is present");
        }
        else
        {
            System.out.println("The Node is not present");
        }
    }
}