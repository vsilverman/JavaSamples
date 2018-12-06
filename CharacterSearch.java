import java.util.Arrays;

/**
 * This class searches in the input sentence
 * all words, containing required characters
 * Let's say the input sentence is {"abc", "def", "acf", "bca", "barc", "collab", "qwe"}
 * And the list of required characters is {'a', 'b', 'c}
 * Then the output should be: "abc bca barc collab",
 * i.e. every of resulting words has in it characters 'a', 'b' and 'c'  
 */

/**
 * @author vlad
 *
 */
public class CharacterSearch {
	
	public String process( String[] in1, Character[] in2) {
		String res = "";
		for (String word: in1) {
			boolean good_word = true;
			for (char c: in2) {
				if (word.indexOf(Character.toString(c)) < 0) {
					good_word = false;
					break;
				}
			}
			if (good_word) {
				res = res + " " + word;
			}
		}		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterSearch cs = new CharacterSearch();
		String[] words = {"abc", "def", "acf", "bca", "barc", "collab", "qwe"};
		Character[] chars = {'a', 'b', 'c'};
		System.out.println("Input sentence: " + Arrays.asList(words));
		System.out.println("Required chars: " + Arrays.asList(chars));

		String result = cs.process(words, chars);
		System.out.println("Result: " + result);
	}

}
