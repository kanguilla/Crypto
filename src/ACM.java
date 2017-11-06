import java.util.ArrayList;
import java.util.SortedSet;

public class ACM {

	public static void main (String[] args){
		
		ACM acm = new ACM();
		
		String ct = "TEBTGFKRZQMLRAIZSZQHJMNWWIPMALNBLTCYLCYKGMDULAPNWUHJOIQVIVQSEGHAMGGXRUIXJXISECDHRMYMHRBRSHRLVRFALQWHCFOKGGILWJHPYTSPTUMMNTEWTDHO";
		acm.attempt(ct, "YAK");
		
		
		String ct2 = "XBEBIIUGPZPCGPMDYWZWGQGGMWQYALGZURRQFWTOLHGQEKDJOHPDFRJFCFVLSOYQXYDNZLVKOCHQAKXPTMQZYZNNWBFNAJPVLAJPVQHZOEBTIRNOQCWUDTVTJWAVOCCOOYVKAALBAINWHMQLBSJRMFXSZFFWHSRFGHYVRPFLDXFJPRHDPAQCGMHSZWCRSTWITKMNGNLHXSNLDRFFKAVNFNHSAUKHLOLWHDHPKLEDLAHFALJRUPPOSQAHNCJHUEAMFKWTOCEWUIAELHBXESEULDEIYOEHZPNMFKWVHVKWFPKYXTIBLULEIWPQITJIYFRZHSBMWHZDFOFBQKLZKNRWMDUEEFBNOXYYPZIBMNHIBGSHKRFUSVOHKCJHIWPUZSSEFUVRYJFPODRUMPXERJNHZCIKGUABFWFKCUTNVIIJNEUKAHBLWDSIMWBMBFWIVUSEJVACOPZUMJOKFPKRTRPKYEECEUXYIVRBNLOSCXOPCXGLCDOTFSRLQFIPTTYWVTZN";
		acm.attempt(ct2, "TYWIN");
	}
	
	private String attempt(String ct, String startKey) {

		int k = ct.length();
		String key = startKey;
		String newKey = "";
		String pt = "";
		
		while(k > 0){	
			newKey = "";
			//System.out.println("Starting round with key " + key);
			for (int i = 0; i < Math.min(key.length(), k); i++){
				//System.out.print("  Shifting " + ct.charAt(ct.length()-k) + " with " + key.charAt(i) + " -> ");
				char c = Util.shiftBack(ct.charAt(ct.length()-k), key.charAt(i));
				pt += c;
				newKey += c;
				//System.out.println(pt + ", and new key = " + newKey);
				k--;
				
			}
			key = newKey;
		}
		
		double d = Util.avgFrequency(pt);
		//System.out.println(Util.avgFrequency(pt) + "  ->  ");
		if (d < 0.6){
			System.out.println(startKey + ">   " + pt);
		}
		return startKey + "=" + d + "=" + pt;
	}

	private void attempt(String ct) {

		System.out.println("Begin attempt");
		
		ArrayList<String> out = new ArrayList<String>();
		
	
		
		for (int i = 5; i < 6; i++){
			SortedSet<String> keys = Util.permute(i);
			System.out.print("Created keys of size " + i);
			for (String key : keys){
				
				//System.out.println("Attempt: " + key + " | ");
				String s = attempt(ct, key);
				
				double d = Double.parseDouble(s.split("=")[1]);
				
				if (d < 0.4){
					out.add(s);
				}
			}
		}
		
		for (String pt : out){
			System.out.println(pt.split("=")[0] + " "+pt.split("=")[1]+" " + pt.split("=")[2]);
		}
		
	}
	
}
