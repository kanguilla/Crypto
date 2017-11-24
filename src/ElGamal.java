import java.math.*;

public class ElGamal {
	
    public static void main(String[] args) {
    	verifySignature(65537, 3, 25733, 42679, 17036, 8676);
    }
    
    public static boolean verifySignature(int p, int g, int y, int r, int s, int m) {
    	if (r < 0 || r > p)return false;
    	if (s < 0 || s > p-1)return false;
    	BigInteger gh = (BigInteger.valueOf(g).modPow(
    			BigInteger.valueOf(m),BigInteger.valueOf(p)));
    	BigInteger yr = (BigInteger.valueOf(y).modPow(
    			BigInteger.valueOf(r),BigInteger.valueOf(p)));
    	BigInteger rs = (BigInteger.valueOf(r).modPow(
    			BigInteger.valueOf(s),BigInteger.valueOf(p)));
    	
    	System.out.println(gh + " = " + yr.multiply(rs).mod(BigInteger.valueOf(p)));
    	return false;
    }
    
    
}