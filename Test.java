import java.util.*;

public class Test {
    public static void main(String args[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 4);
        hm.put(2, 1);
        hm.put(3, 2);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                        return entry2.getValue() - entry1.getValue();
                    }
                });
        Set entry = hm.entrySet();
        System.out.println(entry.toString());
        Iterator it = entry.iterator();
        while(it.hasNext()){
            Map.Entry en = (Map.Entry) it.next();
            System.out.println(en.getKey());
            queue.offer(en);
        }
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < 3; i ++){
            Map.Entry<Integer, Integer> e = queue.poll();
            list.add(e.getValue());
        }
        System.out.println(list.toString());
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
