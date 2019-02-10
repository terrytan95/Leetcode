import java.lang.Math;
import java.math.BigInteger;
public class Test{ 
    public static void main(String args[]){
        int a = 1;
        int b = 2;
        a ^= b; 
        b ^= a; 
        a ^= b; 
        System.out.println(a + " " + b);
    }

    public static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}