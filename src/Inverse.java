import java.math.BigInteger;

public class Inverse {

	public static String modInverse(String ai, String ni) {
		
		BigInteger a = new BigInteger(ai);
		BigInteger n = new BigInteger(ni);
		
		BigInteger i = n, v = BigInteger.ZERO, d = BigInteger.ONE;
		while (a.compareTo(BigInteger.ZERO) > 0) {
			BigInteger t = i.divide(a);
			BigInteger x = a;
			a = i.mod(x);
			
			
			System.out.print(i + " = " + t + "(" + x + ")" + " + " + a);
			
			i = x;
			x = d;
			d = v.subtract(t.multiply(x));
			System.out.println(", d = " + d);
			v = x;
			
			
			
		}
		v = v.mod(n);
		if (v.compareTo(BigInteger.ZERO) < 0)
			v = (v.add(n)).mod(n);
		return v.toString();
	}
   
   public static void main(String[] args) {
	  System.out.println(modInverse("3", "505653012503429218243943633705672380046318162980074400525290686010978535210508251025371556786334751948415457926276892598751961027794016968235973613925881804782472056690499897096340749266251887257171654630228493856549694979043602485084236106517977998198816346622004351187096835097200490691844506811161067102443"));
   }
}