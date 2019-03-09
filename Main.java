import java.util.*;

public class Main {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<Integer>(); 
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        int len = sc.nextInt();
        int[] list = new int[times];
        for (int i = 0; i < times; i++) {
            list[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < times - len; i++){
            set.clear();
            for(int j = i; j < times - 1; j++){
                set.add(list[j]);
                if(set.size() == len){
                    if(j - i + 1 < min){
                        min = j - i + 1;
                        break;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
