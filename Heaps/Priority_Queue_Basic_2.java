// By default the smaller element is given higher priority.
// But it can be changed.
// Input ---> 33 2 5 1 87 96
// Output---> 96 87 33 5 2 1
import java.util.*;
public class Priority_Queue_Basic_2
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            pq.add(val);
        }
        while(pq.size()>0)
        {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}