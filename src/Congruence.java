import java.math.BigInteger;

public class Congruence {

	public static void main(String[] args) {
//		int k = 0;
//		while (40071 != Math.pow(3, k) % 65537) {
//			k++;
//			System.out.println(k);
//		}
//		System.out.println("DONE :" + k);

		System.out.print(BigInteger.valueOf(-5391).modInverse(BigInteger.valueOf(65536)));
	}
	
	public static int GCF(int a, int b) {
	    if (b == 0) return a;
	    else return (GCF (b, a % b));
	}

}
