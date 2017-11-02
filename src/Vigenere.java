import java.util.HashMap;
import java.util.Map.Entry;

public class Vigenere {
	
	private void attempt(String ct) {
		for (int i = 1; i < 10; i++){
			attempt(ct, i);
		}
	}
	
	public void attempt(String ct, int length){
		
		String[] columns = new String[length];
		for (int i = 0; i < ct.length(); i++){
			if (columns[i%length]==null)columns[i%length]="";
			columns[i%length] += ct.charAt(i);
		}
		
		String guess = "";
		
		for (int i = 0; i < columns.length; i++){
			
			HashMap<String, Double> mapping = new HashMap<String, Double>(); //output
			
			
			for (String l : Util.letters){
				String s = Util.decrypt(columns[i], l);
				double avg = Util.avgFrequency(s);
				mapping.put(l, avg);
			}
			
			double min = 100;
			String keyl = "";
			for (Entry<String, Double> e : mapping.entrySet()){
				if (e.getValue() < min){
					min = e.getValue();
					keyl = e.getKey();
				}
			}
			guess += keyl;	
			
		}
		
		System.out.println(Util.decrypt(ct, guess));
		System.out.println("Using key : " + guess);
	}
	

	
	public static void main (String[] args){
		Vigenere v = new Vigenere();
		String ct = "GDYDSXMWLYLVRHOYNSKAVQABCEKQIVWPOPSEYDOBAXGMKJFKPMCSMWYRIZYBYCRGDZYGOFTDNWGUOXJIXCLSREBYTEPEMMMSQUWKABWCRYPDCRKLODFEBWEKPPKQSOQT".toLowerCase();
		v.attempt(ct, 3);
		ct = "QFHRKDMQGERWLDWAELQSUOSDFLOIKBPHYECRJWZOKRXKHPFZIURFKZSKXNUUIGDNUVIYHNKBWLATYRYVDNUWSRQERJELQSKSSVVISOCPXCYKMJKEIZIDUEERAFUUZVMQJAKDPHYECRJWZOKRXKHPFZIURFKZIQWYWLZHWHFXWDQDKRSQHAXDMQVTRQHIDLCLRJDNUZIZLLCEIUHSKRVLQGERVPDLZWCMXSKDWVROEDWZHAIHWXUENKEWLSERVPDLRQCZDYKKEQNYFXXZRTFWLHSONHVRITNHRWBTYRYVDNUWSRQERJELQSKDRGIACOMQJTYHZRLCVFYWRUKISUGAEGEUWHLUAHUEZQEVPACOPXPIERYVSIENGXEITOIIRRUZEVZICGPBHXTLXHGAIWLXUHVVELGTYLWLVFRQXDVTZFAHYESHIQSITNIGXPSBEVKIGSSZHRVGFBWHVLRILNZWILPPIRFDEICLXBGRZYIWKIJLWLQCIHHLELVLLHDRUUYPRRJDFRXTZWFHIOIHXKHYNHVHDLCRJILCZDPOBDVQMHGBLWXKHYDXWWKAMHHRQEZWXKHYMHFXLLKWLHLMGUSEDBZOMWBDILZHDRKKYUWHZVMVDRKKYUZHRWWKDPGHRLQGRUXKXRYDHMDMDHHKLMJHPIDGRLRVWTYHHRRRKRXKHCLEMFOEKUCLQGKRLRODZWGORSVGFXWIKZEVLLCIMWWIEJXLQYWXVUBLZWXOHHRQHVZEIHWTXEVCMQJTYHQVHLMHWWKRFXKKWHVFVDFKJWLHLRWLRJHRJZIUHIENWWDIEHHWLNPYSLFEJFLDWTVUIGLNJDRHOYRUXKXRCRSNHDLSJRUDYHWDLDKKIUHSRQMQIIELXHQUDEIURFDRRNHYJRYWVIUHAKRWRQXWRTROOWRUJDFRXTKKMVVCILTWIOIKEPOEKWLHBVVZSUNEURYWWHVLRILNZWILPPIRFDEICLXBGRZYILVANRRGHRWXPQHWDHXKRDFIGURSJLRJYAJWMQWE".toLowerCase();
		v.attempt(ct);
	}

}
