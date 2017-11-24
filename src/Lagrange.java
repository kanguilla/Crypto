import java.math.BigInteger;

public class Lagrange  {
	

	public static void main (String[] args){
		int[] x = new int[]{15101, 11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
		int[] y = new int[]{3693, 42263, 7819, 64503, 59707, 30654, 7787, 14769, 2946, 47958, 7983};
		
		int[] i = new int[]{0, 1, 2, 3, 4};

		int[] x2 = new int[]{x[i[0]], x[i[1]], x[i[2]], x[i[3]], x[i[4]]};
		int[] y2 = new int[]{y[i[0]], y[i[1]], y[i[2]], y[i[3]], y[i[4]]};

		int[] x4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		int[] y4 = new int[]{16, 5, 5, 16, 7, 9, 22, 15};
		
		int[] x3 = new int[]{1, 5, 7};
		int[] y3 = new int[]{16, 7, 22};
				
		
		
		
		
		
		
		//System.out.println(findSecret3(x, y, 65537));
		//System.out.println(findSecret3(x2, y2, 65537));
		//System.out.println(findSecret3(x3, y3, 31));
		
		BigInteger[] x1 = new BigInteger[5];
		BigInteger[] y1 = new BigInteger[5];
		
		for (int k = 0; k<x1.length;k++) {
			x1[k] = BigInteger.valueOf(x[i[k]]);
			y1[k] = BigInteger.valueOf(y[i[k]]);
		}
		
		
		try {
			System.out.println(findSecret(x1, y1, BigInteger.valueOf(65537)).intValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int a = 0;
//		while (a != 51515) {
//			x1[0] = x1[0].add(BigInteger.ONE);
//			System.out.println(x1[0]);
//			try {
//				a = findSecret(x1, y1, BigInteger.valueOf(65537)).intValue();
//			}catch(Exception e) {
//				continue;
//			}
//		}
//		try {
//			System.out.println("the number is " + x1[0]);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	public static BigInteger findSecret(BigInteger[] x, BigInteger[] y, BigInteger p) throws Exception{

		//System.out.print("Legrange Interpolation using values under group "+p+": ");
		for (int n = 0; n < x.length; n++) {
			//System.out.print("(" + x[n] + "," + y[n] + ") ");
		}
		//System.out.println("\n");
		BigInteger s = BigInteger.ZERO;		
		for (int i = 0; i < x.length; i++) {
			//System.out.println("Calculating Legrange_" + i + " ");
			BigInteger c = y[i];
			for (int j = 0; j < x.length; j++) {
				if (j == i) continue;
				BigInteger ln = (x[j]);
				BigInteger ld = (x[i].subtract(x[j])).mod(p);
				
				BigInteger temp = ld.modInverse(p);
				//System.out.print(x[j] + "/" + x[i] +"-"+ x[j]);
				c = ln.multiply(temp).mod(p).multiply(c).mod(p);
				//if (j != x.length-1) System.out.print(" x ");
			}
			s = s.add(c.mod(p));
			//System.out.println();
		}
		//System.out.println("Secret: " + s.mod(p));
		return s.mod(p);
	}
	
}