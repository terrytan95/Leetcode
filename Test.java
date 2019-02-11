import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;
public class Test{ 
    public static void main(String args[]){
        double[][] array= {
            {1, 5},
            {13, 1.55},
            {12, 100.6},
            {12.1, .85} };
            System.out.println(array[0][0] + " " + array[0][1]);
            System.out.println(array[1][0] + " " + array[1][1]);
            System.out.println(array[2][0] + " " + array[2][1]);
            System.out.println(array[3][0] + " " + array[3][1]);

            java.util.Arrays.sort(array, new java.util.Comparator<double[]>() {
                public int compare(double[] a, double[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });
            System.out.println(array[0][0] + " " + array[0][1]);
            System.out.println(array[1][0] + " " + array[1][1]);
            System.out.println(array[2][0] + " " + array[2][1]);
            System.out.println(array[3][0] + " " + array[3][1]);
    }

    public static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}