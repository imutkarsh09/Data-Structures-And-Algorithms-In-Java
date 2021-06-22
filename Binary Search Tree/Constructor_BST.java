import java.util.*;
public class Constructor_BST
{
    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] Ar, int lo, int hi)
    {
        if(lo>hi)
        {
            return null;
        }
        int mid = lo+(hi-lo)/2;
        int data = Ar[mid];
        Node lc = construct(Ar, lo, mid-1);
        Node rc = construct(Ar, mid+1, hi);
        Node node  = new Node(data, lc, rc);
        return node;

    }
    public static void display(Node node)
    {
        if(node==null)
        {
            return;
        }
        String st = "";
        if(node.left!=null)
        {
            st = st+node.left.data;
        }
        else
        {
            st = st+".";
        }
        st = st+" <- "+node.data+" -> ";
        if(node.right!=null)
        {
            st = st+node.right.data;
        }
        else
        {
            st = st+".";
        }
        System.out.println(st);
        display(node.left);
        display(node.right);

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
        Arrays.sort(Ar);
        Node root = construct(Ar,0,n-1);
        display(root);

    }
}