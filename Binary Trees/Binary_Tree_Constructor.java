import java.util.*;
public class Binary_Tree_Constructor
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data= data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair
    {
        Node node;
        int state;
        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String Args[])
    {
        Integer[] arr= {50,25,12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root,1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while(st.size()>0)
        {
            Pair top = st.peek();
            if(top.state ==1)
            {
                idx++;
                if(arr[idx]!= null)
                {
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                }
                else
                {
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state ==2)
            {
                idx++;
                if(arr[idx]!= null)
                {
                    Node rn = new Node(arr[idx],null, null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                }
                else
                {
                    top.node.right = null;
                }
                top.state++;
            }
            else
            {
                st.pop();
            }
        }
    }
}