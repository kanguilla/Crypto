
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

	public static String eea(long a, long b) {
		long x = 0, y = 1, lastx = 1, lasty = 0, temp;
		while (b != 0) {
			long q = a / b;
			long r = a % b;

			a = b;
			b = r;

			temp = x;
			x = lastx - q * x;
			lastx = temp;

			temp = y;
			y = lasty - q * y;
			lasty = temp;
		}
		return ":" + lastx + "  " + lasty;
	}

	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigInteger privateKey;
	private BigInteger publicKey;
	private BigInteger modulus;

	// generate an N-bit (roughly) public and private key
	RSA(int N) {
		BigInteger p = BigInteger.probablePrime(N / 2, random);
		BigInteger q = BigInteger.probablePrime(N / 2, random);
		BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));

		modulus = p.multiply(q);
		publicKey = new BigInteger("65537"); // common value in practice = 2^16 + 1
		privateKey = publicKey.modInverse(phi);
		
		modulus = new BigInteger("505653012503429218243943633705672380046318162980074400525290686010978535210508251025371556786334751948415457926276892598751961027794016968235973613925881804782472056690499897096340749266251887257171654630228493856549694979043602485084236106517977998198816346622004351187096835097200490691844506811161067102443");
		privateKey = new BigInteger("3");
	}

	BigInteger encrypt(BigInteger message) {
		return message.modPow(publicKey, modulus);
	}

	BigInteger decrypt(BigInteger encrypted) {
		return encrypted.modPow(privateKey, modulus);
	}

	public String toString() {
		String s = "";
		s += "public  = " + publicKey + "\n";
		s += "private = " + privateKey + "\n";
		s += "modulus = " + modulus;
		return s;
	}

	public static void main(String[] args) {
		int N = 100;
		RSA key = new RSA(N);
		System.out.println(key);

		//// create message by converting string to integer
		String s = "427680787658796414495478412765818481773700031964971550032485995462094541318172071699678633526190831000613031464300541848882252073989630802044992230370499993349891121354055409063481101792420859297579606741599372692821291104228771117776673746157967849667351681259816188574800065511460953723930836865732656293632";
		byte[] bytes = s.getBytes();
		BigInteger message = new BigInteger(bytes);

		BigInteger encrypt = key.encrypt(message);
		BigInteger decrypt = key.decrypt(encrypt);
		System.out.println("message   = " + message);
		System.out.println("encrypted = " + encrypt);
		System.out.println("decrypted = " + decrypt);

		System.out.println(new String(encrypt.toByteArray()));
	}
}
