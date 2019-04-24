import java.util.HashSet;

/**
 *	Requirements
 *
 *	This application takes a single string as input.  
 *  A function `removeDuplicates`  removes duplicate letters, case insensitively, so 
 *  that every letter appears once and only once. 
 *  It always keeps the first occurrence of a letter, regardless of case.
 *  The function should only accept uppercase and lowercase letters.
 *  Your application should output the result of this function when called on the input string to 
 *  the console.
 *
 *  The application may not terminate due to exceptions or errors, including if we test the 
 *  program with different inputs than the example provided.
 *
 * Example: the output from an input String of "AbraCadABraAlakAzam" is shown below.
 * 
 * AbrCdlkzm
 */

/**
 * @author Vlad
 *
 */
public class RemoveDuplicatesInString {
	
	public static String DEFAULT_STR = "AbraCadABraAlakAzam";

	public String removeDuplicates(String s) {
		String res = "";
		if (!s.matches("[A-Za-z]+"))
			return res;
		HashSet<Character> hs = new HashSet<Character>();
		char[] charr = s.toCharArray();
		char chl;
		for (char ch : charr) {
			chl = Character.toLowerCase(ch);
			if (hs.add(chl) == true) {
				res += ch;
			}
		}
		System.out.println(res);
		return res;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = DEFAULT_STR;
		if (args.length > 0) 
			str = args[0];
//		System.out.println("Original string: " + str);
		RemoveDuplicatesInString dis = new RemoveDuplicatesInString();
		dis.removeDuplicates(str);
	}

}
