import java.util.*;
public class Mirror_Generic_Tree
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node)
    {
        String str = node.data+" -> ";
        for(Node child:node.children)
        {
            str = str +child.data+",";
        }
        str=str+" .";
        System.out.println(str);
        for(Node child: node.children)
        {
            display(child);
        }
    }
    public static void mirror(Node node)
    {
        for(Node child:node.children)
        {
            mirror(child);
        }
        Collections.reverse(node.children);
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
                Node t= new Node();
                t.data= i;
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
        System.out.println("Original Tree----->");
        display(root);
        System.out.println("Mirror Tree------>");
        mirror(root);
        display(root);
    }
}