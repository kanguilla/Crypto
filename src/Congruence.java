import java.math.BigInteger;

public class Congruence {

	public static void main(String[] args) {
		System.out.println(linearCongruence((43009-17409), (1125-101), 65536).mod(BigInteger.valueOf(65536)));
	}
	
	public static BigInteger linearCongruence (int s, int m, int modulus){
		return BigInteger.valueOf(m).multiply(BigInteger.valueOf(s).modInverse(BigInteger.valueOf(modulus)));
	}

}
