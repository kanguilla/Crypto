

public class Lagrange  {
	

	public static void main (String[] args){
		int[] xx = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
		int[] yy = new int[]{42263, 7819, 64503, 59707, 30654, 7787, 14769, 2946, 47958, 7983};
		
		int[] i = new int[]{0, 8, 1, 3, 5};
		
		int[] xx2 = new int[]{xx[i[0]], xx[i[1]], xx[i[2]], xx[i[3]], xx[i[4]]};
		int[] yy2 = new int[]{yy[i[0]], yy[i[1]], yy[i[2]], yy[i[3]], yy[i[4]]};
		
		int[] xx3 = new int[]{2, 4, 5};
		int[] yy3 = new int[]{1942, 3402, 4414};
		
		(new Lagrange()).calculateResult(xx, yy);
		
	}
	
	public void calculateResult(int[] xx, int[] yy){
		int n = xx.length;
		
		int total = 0;
		
		for (int i = 0; i < n; i++) {
			System.out.println("Calculating Legrange_" + i + " ");
			double leg = 1;
			
			for (int j = 0; j <  n; j++) {
				
				if (i != j) {
					double ln = (0 - xx[j]);
					double ld = (xx[i] - xx[j]);
					System.out.print(" 0-" + xx[j] + "/" + xx[i] +"-"+ xx[j] + "["+ln/ld+"]");
					leg = leg * ln/ld;
					if (j != n-1) System.out.print(" x");
				}
				
				
			}
			System.out.println("\n"+leg + " x " + yy[i]);
			total += leg * yy[i];
			System.out.println();
		}
		
		System.out.println("FINAL: " + total % 65537);
	}

	@Override
	public String toString(){
		return "Lagrange";
	}
}