import java.util.*;

public class Test {
    public static void main(String args[]) {
        int i = 0;
        int j = i + 2;
        i++;
        i++;
        System.out.println(j);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
