import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

public class Factoring {

	/*
	public static void main (String[] args){
		try {	
			String numbers = new String(Files.readAllBytes(Paths.get("N79.txt")));
			
			HashMap<Integer, BigInteger> x = new HashMap<Integer, BigInteger>();
			
			for (String s : numbers.trim().split("N")){
				String[] s1 = s.trim().split(":");
				if (s1[0].equals(""))continue;
				int index = Integer.parseInt(s1[0].trim());
				String prime = s1[1].trim();
				x.put(index, prime);
			}
			
			System.out.println(rho(Integer.parseInt(x.get(1))));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	public static int gcd(int a, int b) {
		int remainder;
		while (b != 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}
	
	public static int rho (int prime) {
		int number = prime, x_fixed = 2, cycle_size = 2, x = 2, factor = 1;

		while (factor == 1) {
			for (int count=1;count <= cycle_size && factor <= 1;count++) {
				x = (x*x+1)%number;
				factor = gcd(x - x_fixed, number);
			}

			cycle_size *= 2;
			x_fixed = x;
		}
		return factor;
	}

}