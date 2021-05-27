import java.util.*;
public class Maximum_Sum_Subtree
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
    static int msn = 0;
    static int ms = Integer.MIN_VALUE;
    public static int sumSubTree(Node node)
    {
        int sum = 0;
        for(Node child:node.children)
        {
            int cs = sumSubTree(child);
            sum = sum +cs; 
        }
        sum = sum + node.data;
        if(sum>ms)
        {
            ms = sum;
            msn = node.data;
        }
        return sum; 
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Ar = new int[n];
        for(int i=0; i<n;i++)
        {
            Ar[i] = sc.nextInt();
        }
        Node n1 = construct(Ar);
        sumSubTree(n1);
        System.out.println("Maximum Sum is "+ms+ " @ Node "+msn);
    }
}