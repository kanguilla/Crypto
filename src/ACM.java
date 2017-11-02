
public class ACM {

	public static void main (String[] args){
		
		ACM acm = new ACM();
		
		String ct = "TEBTGFKRZQMLRAIZSZQHJMNWWIPMALNBLTCYLCYKGMDULAPNWUHJOIQVIVQSEGHAMGGXRUIXJXISECDHRMYMHRBRSHRLVRFALQWHCFOKGGILWJHPYTSPTUMMNTEWTDHO";
		acm.attempt(ct, "YAK");
		
		ct = "MOGRVQOQRIKEGSRKNVYFKHBXCVHBXMLHOYGFHRGXLXEQLTMJOQXDLGWOCOPOTURZWANAALCHRFHTDRLPESXRHFFEQGVBPDKTGVCPCLDGOADYPTEEVGSKTVVECCVFXEBROUBXEXPXFRFKHRWOIKTUCPFWXZXCQWLWBFJEKIZJLLGWVWUOQWSJUWFJWWLEGWSUMODCKBALWPYLGPIIJBBCFHECGNIOXUXUHLVETNVTNFTNLAAVPQFHRVPOBEQICMXPEPYOLDPAEQZSFHIVDAUAMFPSKJLHVDVEGCARPIOJBMBDPBTKWKINSMAHEJNGFMTJORBMBAUEEKYHOMSJSLIDYVTNAUPSIPHUTAZGNVCFPRJBGTWTRQFTBTBBBYFLRHBQHVOSEDFIXENSPHBWOAGQUWFDIOLYBXWTQJUYPXWPTXRLSIAMFAAMZXJSFMEXJSZLWWPWNWTHIJESXRSZHHEVLPEMHJHHOLEISDBRKDEVGVLPTZWFINGNLMPVVZZGUBZX";
		acm.attempt(ct);
	}
	
	private void attempt(String ct, String startKey) {
		
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
		if (Util.avgFrequency(pt) < 0.5)System.out.println(pt);
	}

	private void attempt(String ct) {
		for (int i = 1; i < 5; i++){
			for (String key : Util.permute(i))
			attempt(ct, key);
		}
	}
	
}
