import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class Predecessor_And_Successor
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node construct(int[] Ar)
    {
        Stack<Node> st =new Stack<>();
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
    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data)
    {
        if(state==0)
        {
            if(node.data==data)
            {
                state=1;
            }
            else
            {
                predecessor = node;
            }
        }
        else if(state==1)
        {
            successor = node;
            state = 2;
        }
        for(Node child:node.children)
        {
            predecessorAndSuccessor(child,data);
        }
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
        Node n1 = construct(Ar);
        System.out.println("Enter the node to be searched: ");
        int data=sc.nextInt();
    predecessor = null;
    successor = null;
    state=0;
    predecessorAndSuccessor(n1, data);
    if(predecessor == null)
    {
        System.out.println("Predecessor : Null");
        System.out.println("Successor : "+successor.data);
    }
    else if(successor== null)
    {
        System.out.println("Predecessor : "+predecessor.data);
        System.out.println("Successor : Null");
    }
    else
    {
    System.out.println("Predecessor : "+predecessor.data);
    System.out.println("Successor : "+ successor.data);
    }
}
}