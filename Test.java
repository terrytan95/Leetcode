import java.util.*;
class IntComparator implements Comparator<Integer>{
    public int compare(Integer i, Integer j){
        if(i < j) return 1;
        if(i > j) return -1;
        if(i == j) return 0;
        return 0;
    }
}
public class Test {
    public static void main(String args[]) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new IntComparator());
        q.offer(3);
        q.offer(4);
        q.offer(7);
        q.offer(1);
        q.offer(5);
        System.out.println(q);
        
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
