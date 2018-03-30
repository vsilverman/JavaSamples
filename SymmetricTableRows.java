import java.util.HashMap;

/**
 * This program prints out 
 * original two column table
 * and provides 2 solutions
 * to find all symmetric rows
 * in the original table
 */

/**
 * @author Vlad
 *
 */
public class SymmetricTableRows {
	
	private static int[][] myTable = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
	
	public void printTable(int[][] table) {
		String printout = "Original table\n";
		for (int row= 0; row < table.length; row++) {
			for (int col=0; col<table[0].length; col++) {
				printout += table[row][col] + " ";
			}
			printout += "\n";
		}
		System.out.println(printout);
	}

	
	public void findSymPairs(int[][] table) {
		String symPairs = "Symmetric pairs - nested loop solution\n";
		for (int r = 0; r < table.length; r++) {
			for (int row = r+1; row < table.length; row++) {
				if (table[r][1]==table[row][0]) {
					if (table[r][0]==table[row][1]) {
//						symPairs += "Row#" + r + ": ";
						symPairs += table[r][0] + " ";
						symPairs += table[r][1] + " ";
						symPairs += "<---> ";
//						symPairs += "Row#" + row + ": ";
						symPairs += table[row][0] + " ";
						symPairs += table[row][1] + " ";
						symPairs += "\n";
					}
				}
			}
		}
		System.out.println(symPairs);
	}
	
	// This is another more elegant solution using HashTable 
	// to print all pairs that have a symmetric counterpart
    public void findSymPairs2(int table[][]) {
    	System.out.println("Symmetric pairs - hashmap solution");
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < table.length; i++) {
            // save first and second elements of current pair
            int first = table[i][0];
            int sec   = table[i][1];
            // Look up for second element of this pair in hash
            Integer val = hm.get(sec);
            // If found and value in hash matches 
            // with first element of this pair, 
            // we found symmetry
            if (val != null && val == first)
               System.out.println("(" + sec + ", " + first + ")");
            else  // Else put sec element of this pair in hash
               hm.put(first, sec);
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTableRows symrows = new SymmetricTableRows();
		symrows.printTable(myTable);
		symrows.findSymPairs(myTable);
		symrows.findSymPairs2(myTable);
	}

}
