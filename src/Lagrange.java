
import java.util.Vector;

public class Lagrange  {
	private int n = 0;
	private double sum = 0, product = 0;

	public static void main (String[] args){
		int[] xx = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
		int[] yy = new int[]{42263, 7819, 64503, 59707, 30654, 7787, 14769, 2946, 47958, 7983};
		
		System.out.println((new Lagrange()).calculateResult(5, xx, yy));
		
	}
	
	public double calculateResult(int[] xx, int[] yy){
		n = xx.length;
			
		for (int i = 0; i < n; i++) {
			product = yy[i];
			for (int j = 0; j <  n; j++) {
				if (i != j) {
					product = product * (0 - xx[j]) / (xx[i] - xx[j]);
				}
			}
			sum = sum + product;
		}
		
		return sum;
	}

	@Override
	public String toString(){
		return "Lagrange";
	}
}