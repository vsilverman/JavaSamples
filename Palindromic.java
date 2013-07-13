
import java.util.ArrayList;

public class Palindromic {
	
	public int max = 10000;
	public int numbers[] = new int[max];
	public static ArrayList result = new ArrayList();
	
	public Palindromic() {
		for (int i=0; i<max; i++) {
			numbers[i] = i;
		}
	}
	
	public void findAllNumbers() {
		String s;
		int len;
		boolean PalindromicNumber;
		for (int i=0; i<max; i++) {
			s = String.valueOf(numbers[i]);
			len = s.length();
			PalindromicNumber=true;
			for (int j=0; j<=len/2; j++) {
				if(s.charAt(j)!=s.charAt(len-1-j)) {
					PalindromicNumber = false;
					break;
				}
			}
			if (PalindromicNumber) {
				result.add(numbers[i]);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palindromic pal = new Palindromic();
		pal.findAllNumbers();
		System.out.println("Palindromic Numbers: " + result.toString());
	}

}
