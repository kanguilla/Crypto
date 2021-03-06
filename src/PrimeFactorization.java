
import java.math.BigInteger;
import java.security.SecureRandom;
    

public class PrimeFactorization {
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger prho(BigInteger product) {
        BigInteger divisor;
        
        BigInteger a  = new BigInteger(product.bitLength(), random);
        BigInteger b  = new BigInteger(product.bitLength(), random);
        BigInteger c = b;

        if (product.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            b  =  b.multiply(b).mod(product).add(a).mod(product);
            c = c.multiply(c).mod(product).add(a).mod(product);
            c = c.multiply(c).mod(product).add(a).mod(product);
            divisor = b.subtract(c).gcd(product);
        } while((divisor.compareTo(ONE)) == 0);

        return divisor;
    }

    public static void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(100)) { System.out.println(N); return; }
        BigInteger divisor = prho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

    public static void totient(BigInteger A, BigInteger B) {
    	
    	BigInteger N = A.multiply(B);
    	BigInteger phi = N.subtract(A).add(B).add(ONE);
    	System.out.println(phi);
    }
    

 
    public static void main(String[] args) {
        BigInteger N = new BigInteger("13029506445953503759481");
        factor(N);
        totient(new BigInteger("119298960679"), new BigInteger("109217267039"));
        System.out.println(new BigInteger("9292162750094637473537").modInverse(new BigInteger("13029506445943422065842")));
    }
}
