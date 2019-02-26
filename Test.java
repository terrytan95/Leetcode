import java.util.*;

public class Test {
    public static void main(String args[]) {
        int[] i = {1,2,3,4,5};
        System.out.println(i[i.length - 1]);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
