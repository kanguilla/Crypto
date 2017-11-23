
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

	BigInteger encrypt2(BigInteger message) {
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
//		int N = 100;
//		RSA key = new RSA(N);
//		System.out.println(key);
//
//		//// create message by converting string to integer
//		String s = "427680787658796414495478412765818481773700031964971550032485995462094541318172071699678633526190831000613031464300541848882252073989630802044992230370499993349891121354055409063481101792420859297579606741599372692821291104228771117776673746157967849667351681259816188574800065511460953723930836865732656293632";
//		byte[] bytes = s.getBytes();
//		BigInteger message = new BigInteger(bytes);
//
//		BigInteger encrypt = key.encrypt2(message);
//		BigInteger decrypt = key.decrypt(encrypt);
//		System.out.println("message   = " + message);
//		System.out.println("encrypted = " + encrypt);
//		System.out.println("decrypted = " + decrypt);
//
//		System.out.println(new String(encrypt.toByteArray()));
		
		BigInteger m = new BigInteger("169051735219277475590231826992974517584441289846373794226549986850732257294817560343439820742236655054611741163389887885546533767164727501809070917083967679791988612511599825319307291827649611965899446561279620094290833000580211022270963614195517284629675578909864668070831108552374275648786037092684278007819");
		BigInteger e = new BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137235");
		BigInteger N = new BigInteger("265395747779081530877606237236349849228314744900899433856115970650569628926732597441099813244463093724241524668073327069367685544353023894309092930986368718041241356517138905842047363627287275378041992895737394917902969620822954148050418803997890441829764379787051809840244543961639445759733471607073670456391");
		System.out.println(encrypt(m,e,N));
		
	}
	
	public static BigInteger encrypt(BigInteger message, BigInteger pExponent, BigInteger modulus) {
		return message.modPow(pExponent, modulus);
	}

}
