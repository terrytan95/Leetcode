import java.util.Arrays;
import java.util.LinkedList;

public class Test{ 
    public static void main(String args[]){

        ListNode i = new ListNode(1);
        ListNode j = i;
        ListNode o = new ListNode(5);
        j.next = o;
        System.out.println(i.next.val);
    }

}

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
