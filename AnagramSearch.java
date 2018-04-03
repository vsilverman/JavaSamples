import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Vlad
 * 
 * This class maintains a history of searched words
 * and can process a sequence of one word searches.
 * In case this word is new it is added to history,
 * prints out the currently searched word and 
 * previously searched anagrams of this word. 
 * In case this word was searched before - no action.
 * 
 * Let's say we have the following search history: "13254 32145 cicos 24135 osicc"
 * in this case the result of new searches should be:
 *     Search word: cisco -> Anagram Search History: "cicos osicc cisco"
 *     Search word: 12345 -> Anagram Search History:  "13254 32145 24135"
 *     Search word: new   -> Anagram Search History:  "new"
 *     Search word: 13254 -> no action
 *     
 * Our algorithm:  
 *  - for every element of initial array of search words
 *  	- sort word by characters
 *  	- try adding sorted word to the hashtable history_ht, which contains
 *  		 word sorted by chars/set of previously searched anagrams
 *  	- if sorted word exists in history_ht try adding search word to 
 *  		corresponding set of previously searched anagrams 
 *
 */

public class AnagramSearch {
	
	public final static String HISTORY = "13254 32145 cicos 24135 osicc";
	public final static String[] SEARCH_WORDS = {"cisco", "12345", "new", "13254"};
	
	public static Map<String, Set<String>> history_ht = new Hashtable<String, Set<String>>();
	
	public AnagramSearch() {
		System.out.println("\nInitializing Anagram Search History...");
		String[] history_words = HISTORY.split(" ");
		for (String hw : history_words) {
			process(hw);
		}
		System.out.println("...End of Init Process\n");
	}

	public void process(String search) {
		Set<String> new_set = new HashSet<String>();
		Set<String> history_set = new HashSet<String>();
		String sorted = sortChars(search);
		history_set = history_ht.get(sorted);
		if (history_set == null) {
			new_set.add(search);
			history_set = new_set;
		}
		else {
			// this word is an anagram, i.e. it already exists in istory_ht hashtable
			if (history_set.add(search)==false) {
				// this word was already searched before
				return;
			}
		}
		history_ht.put(sorted, history_set);
		System.out.println("Anagram Search History: " + history_set.toString());
	}
	
	private String sortChars(String s) {
		char[] charr = s.toCharArray();
		Arrays.sort(charr);
		String sortedStr = new String(charr);
		return sortedStr;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] search_words = AnagramSearch.SEARCH_WORDS;
		if (args.length < 1) {
			System.out.println("Using default list of Search Words"); 
		}
		else {
			for (int i=1; i < args.length; i++) {
				search_words[i] = args[i];
			}
		}
		System.out.println("Search Words: " + Arrays.asList(search_words));
		AnagramSearch a_search = new AnagramSearch();
		for (String word : search_words) {
			System.out.println("\nSearch word: " + word);
			a_search.process(word);
		}
	}

}
