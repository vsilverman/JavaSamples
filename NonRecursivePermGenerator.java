
/*
publWelcome to PiratePad!

This pad text is synchronized as you type, so that everyone viewing this page sees the same text.  This allows you to collaborate seamlessly on documents!
 
 
Write a method in Java to:
Find all set of permutations from N number of ArrayLists. Each ArrayList has a different length. 
Each permutation is formed by picking one item from each input ArrayList.
You have to exhaust ALL permutations and can't return duplicate permuations. 
Each permutation is a Set, so the order of the items does not matter. For example [a1,b1,c1] is the same permutation as [c1,b1,a1].
Example:
Input: N number of array lists with different length
[a1,a2,a3....]
[b1,b2....]
[c1, c2... ]
 
...
Output: ALL permutations
[a1, b1, c1...], 
[a1,b1,c2..]
....
Note: the above example is just a sample of potential input to illustrate the output. You have to write code to solve for generalized input.
Please type in Priratepad so we can follow your thought process.
Show us your most elegant solution!
*/
 
// ---vs  
// *** Task is above.  My 30min implementation is below ***

 //need to import Set & ArrayList
 import java.util.Set;
 import java.util.HashSet;
 import java.util.ArrayList;
 import java.util.Iterator;
 
 public class NonRecursivePermGenerator {
     
     static int N=2; 
     // in the future we can read this number from file or pass as param to the main method
     // just for now for simplicity assuming this number is 2
     
// here are only 2 arrayLists
// for production code... we can read those arrayLists from ASCII file
     static ArrayList<String> a1 = new ArrayList<String>();
     static ArrayList<String> a2 = new ArrayList<String>();
     
     public NonRecursivePermGenerator() {
         for (int i=0; i<3; i++) {
             a1.add("a");
             a1.add("b");
             a1.add("c");
         }
         for (int i=0; i<2; i++) {
             a2.add("d");
             a2.add("e");
         }
     }
     
     public static String generate() {
     // this method will do main processing
     // we can use nested loops or recursive calls
     
       String res = " ";
         
    	 for (int i=1; i<=3; i++) {
    		 for (int j=1; j<=2; j++) {
    		     Set<String> set = new HashSet<String>();
//                 need to go thru every element of the 2nd arraylist a2
//                 and concat it to selected element from the 1sr arraylist a1
//                 and write result into resulting Set
    			 set.add(a1.get(i));
    			 set.add(a2.get(j));
//                concat Set to result String

    			  res = res.concat(set.toString());
             }
        }
        
        return res;
    }
     
     
     public static void main (String[] args) {
    	 NonRecursivePermGenerator nrpg = new NonRecursivePermGenerator();
         System.out.println(nrpg.generate());
     }
     
     // for production code we'll need to use recursion and i/o from ext file
}
