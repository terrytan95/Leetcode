import java.lang.Math;
import java.math.BigInteger;
public class Test{ 
    public static void main(String args[]){
        
    }

    public static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}