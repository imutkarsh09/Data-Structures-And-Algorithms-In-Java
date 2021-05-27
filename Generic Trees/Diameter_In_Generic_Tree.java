import java.util.*;
public class Diameter_In_Generic_Tree
{
    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node construct(int[] Ar)
    {
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
        return root;
    }
    static int dia = 0;

    static int getNodeReturnHeight(Node node)
    {
        int dch = -1;
        int sdch = -1;
        for(Node child:node.children)
        {
            int ch = getNodeReturnHeight(child);
            if(ch>dch)
            {
                sdch = dch;
                dch = ch;
            }
            else if(ch>sdch)
            {
                sdch = ch;
            }
        }
        if((dch + sdch +2)>dia)
        {
            dia = dch + sdch +2;
        }
        dch = dch +1;
        return dch;
    }
    public static void main(String Args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i =0 ;i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        Node root = construct(Ar);
        getNodeReturnHeight(root);
        System.out.println("Diameter of the tree is : "+dia); 
    }
}