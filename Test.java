import java.util.Arrays;
import java.util.LinkedList;

public class Test{ 
    public static void main(String args[]){

        int number = 35642536;
        String temp = Integer.toString(number);
        int[] array = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            array[i] = temp.charAt(i) - '0';
        }

        Arrays.sort(array);
        for (int i : array) { 
            System.out.print(i + " "); 
        } 
        int res=0;
        for(int i=0;i<array.length;i++) {
            res=res*10+array[i];
        }
        System.out.println(res);
    }

}
