import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
public class Remove_Leaves
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node)
    {
        String str = node.data+" -> ";
        for(Node child: node.children)
        {
            str = str+child.data+",";
        }
        str=str+".";
        System.out.println(str);
        for(Node child:node.children)
        {
            display(child);
        }
    }
    public static void removeLeaves(Node node)
    {
        for(int i= node.children.size()-1;i>=0;i--)
        {
            Node child =node.children.get(i);
            if(child.children.size()==0)
            {
                node.children.remove(child);
            }
        }
        for(Node child: node.children)
        {
            removeLeaves(child);
        }
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] Ar =  new int[n];
        for(int i=0;i<n;i++)
        {
            Ar[i]=sc.nextInt();
        }
        Stack<Node> st= new Stack<>();
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
        System.out.println("Tree Before Removing leaf Nodes-->");
        display(root);
        System.out.println("Tree After Removing leaf Nodes-->");
        removeLeaves(root);
        display(root);
    }
}