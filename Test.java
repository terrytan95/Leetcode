import java.util.Arrays;
import java.util.LinkedList;

public class Test{ 
    public static void main(String args[]){
        String i = "asdnqjskjzbckjzABBAVYDUAIXBZJX";
        i = i.replaceAll("[aeiouAEIOU]", "");
        System.out.println(i.codePointAt(2));
    }

}

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
