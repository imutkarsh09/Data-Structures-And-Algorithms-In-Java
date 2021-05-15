import java.util.*;
public class Distance_Between_Two_Node
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
    public static int dbn(Node node, int d1, int d2)
    {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);
        int i = p1.size()-1;
        int j = p2.size()-1;
        while(i>=0 && j>=0 && p1.get(i)==p2.get(j))
        {
            i--;
            j--;
        }
        i++;
        j++;
        return(i+j);
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
        System.out.println("Enter the nodes whose distance is to be found...");
        int d1 = sc.nextInt();
        int d2 =sc.nextInt();
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
                t.data = i;
                if(st.size()==0)
                {
                    root = t;
                }
                else
                {
                    st.peek().children.add(t);
                }
                st.push(t);
            }
        }
        int ans  = dbn(root,d1,d2);
        System.out.println(ans);
    }
}