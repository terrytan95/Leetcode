import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < times; i++) {
            int x = sc.nextInt();
            queue.offer(x);
        }
        System.out.println(getSum(queue));
    }

    public static String getSum(Queue<Integer> list) {
        String result = "";
        Queue<Integer> queue = new LinkedList<Integer>(list);
        while(!queue.isEmpty()) {
            int left = queue.poll();
            int right = queue.poll();
            if(left % 2 == 1 && right % 2 == 1){
                result += result + (- left - right) + "\n";
            }else if(left % 2 == 0 && right % 2 == 1){
                result += result + (- right + left) + "\n";
            }else if(left % 2 == 1 && right % 2 == 0){
                result += result + (right - left) + "\n";
            }else if(left % 2 == 0 && right % 2 == 0){
                result += result + (right + left) + "\n";
            }
        }
        return result;
    }
}
