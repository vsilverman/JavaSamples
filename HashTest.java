import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class HashTest {
  
//	import java.util.Hashtable;

	/**
	 * @param args
	 */
	
	public HashTest() {
		
	}
	
	public static void main(String[] args) {
//		
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "one");
		ht.put(2, "two");
		ht.put(3, "three");
		ht.put(4, "four");
		ht.put(5, "five");

// Map is unsorted		
		System.out.println("ht.toString() = " + ht.toString());

// To traverse through the map, first get the Set of keys using the keySet()
		Set<Integer> keyset = ht.keySet();

//		To go through the keys in natural sorted order, 
//		you can wrap the keys in a TreeSet
		Set<Integer> keys = new TreeSet<Integer>(keyset);
		Iterator<Integer> i = keys.iterator();
		while (i.hasNext()) {
			Object key = i.next();
			Object value = ht.get(key);
			System.out.println(key + "," + value);
		}
		
// another way get sorted collection is to explicitly use
// Collections.sort(...) method
		ArrayList<Integer> arlist = new ArrayList<Integer>(keyset); 
		Collections.sort(arlist); 
		for (Iterator<Integer> itrtr = arlist.iterator(); itrtr.hasNext();) { 
			Object val = ht.get(itrtr.next());
			System.out.println(val.toString());
		} 

	}

}
