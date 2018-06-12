/**
 * @author Vlad S.
 * 
 * This program counts the frequency of characters.
 * The input file contains ASCII characters between
 *  0x20 to 0x7E. 
 *  Using some file or a string as input. 
 *  Output is in a file "frequency.txt". 
 *  Example Output format below. 
 *  (The first line is counting the blanks)
 *   :50
 *   -:90
 *   a:55
 *   b:98
 *   c:105
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FrequencyCounter {
	
//	static final String INFILE = "d:\\test_results.txt";  // the sample source file
	static final String INFILE = "d:\\words.txt";  // the sample source file
	static final String OUTFILE = "d:\\frequency.txt"; // output file name

	static final int MY_MIN_ASCII = 32;  // 0x20
	static final int MY_MAX_ASCII = 126; // 0x7E
	
	public static int[] counter = new int[95];
	
	/**
     * this method reads the input file
     * and fills out the counter array
     */ 
	 public static void countFrequency(BufferedReader in) throws IOException  
	 { 
		 String s; 
		 while((s = in.readLine())!=null) { 
			 for (int i=0; i < s.length(); i++) {
				for (int j=MY_MIN_ASCII; j<=MY_MAX_ASCII; j++) {
					if(j == s.charAt(i))
						counter[j-MY_MIN_ASCII]++;
				}
			 }
		 }
	 }
	 
		/**
	     * this method reads the input string
	     * and fills out the counter array
	     */ 
		 public static void countFrequency(String s) throws Exception  
		 {
			 if (s == null)
				 throw new Exception ("null parameter is passed");
			 for (int i=0; i < s.length(); i++) {
				for (int j=MY_MIN_ASCII; j<=MY_MAX_ASCII; j++) {
					if(j == s.charAt(i))
						counter[j-MY_MIN_ASCII]++;
				}
			 }
		 }
		 
		/**
	     * this method prints results...
	     */ 
	 public static void printResults (PrintWriter out) {
		for (int j=MY_MIN_ASCII; j<=MY_MAX_ASCII; j++) {
			int frequency = counter[j-MY_MIN_ASCII];
			if (frequency > 0) {
				if (out!= null)
					out.println((char)j + ":" + frequency);
				else
					System.out.println((char)j + ":" + frequency);
			}
		}
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, Exception {
	    if (args.length > 0) {
	    	countFrequency(args[0]);
	    	printResults(null);
	    }
	    else {
			BufferedReader in = new BufferedReader(new FileReader(INFILE)); 
			PrintWriter out = new PrintWriter(new FileWriter(OUTFILE));
		    countFrequency(in);	    	
		    printResults(out);
		    in.close();
		    out.close();
	    }
	}

}
