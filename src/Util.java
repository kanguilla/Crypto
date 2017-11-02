import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Util {
	
	public static String[] letters = {"A", "B", "B", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public static final Map<String, Double> fq = initfq();
	private static Map<String, Double> initfq(){
		Map<String, Double> fq = new HashMap<String, Double>();
        fq.put("A", 0.082);
        fq.put("B", 0.015);
        fq.put("C", 0.028);
        fq.put("D", 0.043);
        fq.put("E", 0.127);
        fq.put("F", 0.022);
        fq.put("G", 0.020);
        fq.put("H", 0.061);
        fq.put("I", 0.070);
        fq.put("J", 0.002);
        fq.put("K", 0.008);
        fq.put("L", 0.040);
        fq.put("M", 0.024);
        fq.put("N", 0.067);
        fq.put("O", 0.075);
        fq.put("P", 0.019);
        fq.put("Q", 0.001);
        fq.put("R", 0.060);
        fq.put("S", 0.063);
        fq.put("T", 0.091);
        fq.put("U", 0.028);
        fq.put("V", 0.010);
        fq.put("W", 0.024);
        fq.put("X", 0.002);
        fq.put("Y", 0.020);
        fq.put("Z", 0.001);
        return fq;
	}

	public static int ndex(String s){
		for (int i = 0; i < letters.length; i++){
			if (s.equals(letters[i]))return i;
		}
		return -1;
	}
	
	public static ArrayList<String> permute(String[] alphabet, int k) {
		
		ArrayList<String> a = new ArrayList<String>();
		
	    int permutationNumber = (int) Math.pow(alphabet.length, k);
	    for (int i = 0; i < permutationNumber; i++) {
	    	String s = "";
	       for (int j = 0; j < k; j++) {
	          s += (alphabet[(i + (j * i / alphabet.length)) % alphabet.length]);
	       }
	       a.add(s);
	    }
	    
	    return a;
	 }


	public static ArrayList<String> permute(int i) {
		return permute(letters, i);
	}
	
	public static double avgFrequency(String ct){
		
		double total = 0.0;
		
		for (Entry<String, Double> e : Util.fq.entrySet()){
			double count = 0;
			for (char c : ct.toCharArray()){
				if (e.getKey().equals(String.valueOf(c)))count++;
			}
			double frequency = count / ct.length(); 
			double distance = Math.abs(frequency - e.getValue());
			//System.out.println(e.getKey() + " : " + distance);
			total += distance;
		}
		return total; //for (char c )
	}
	
	public static String crypt(String ct, int shift){
		if (shift >= 0){
			return crypt(ct, String.valueOf((char) ((shift + 65) % 26)), true);
		}else{
			return crypt(ct, String.valueOf((char) ((Math.abs(shift) + 65) % 26)), false);
		}
	}
	
	public static String encrypt(String ct, String key){return crypt(ct, key, true);}
	public static String decrypt(String ct, String key){return crypt(ct, key, false);}
	
	public static String crypt(String ct, String key, boolean encrypt){
		char[] ch  = ct.toCharArray();
		String out = "";
		for (int i = 0; i < ch.length; i++){
			
			int c = (int) (ch[i]) -97;
			int shift = (encrypt ? 1 : -1) * (int) ((key.charAt(i%key.length()))-65)% 26;
			
			out += (char) (((c +  shift + 26) % 26) + 65);
		}
		return out;
	}

	public static char shift(char a, char b) {
		int ai = a - 65;
		int bi = b - 65;
		
		return (char) (((ai + bi)%26) + 65);
	}
	
	public static char shiftBack(char a, char b) {
		int ai = a - 65;
		int bi = b - 65;
		
		return (char) (((ai - bi + 26 )%26) + 65);
	}
	
	public static char shift(char a, int s) {
		int ai = a - 65;
		
		return (char) (((ai + s + 26)%26) + 65);
	}
}
