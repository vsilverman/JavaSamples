/**
 * This program prints out 
 * original 2 column table
 * and all symmetric rows
 * in the original table
 */

/**
 * @author Vlad
 *
 */
public class SymmetricTableRows {
	
	private static int[][] myTable = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
	
	public void findSymPairs(int[][] table) {
		String printout = "Original table\n";
		for (int row= 0; row < table.length; row++) {
			for (int col=0; col<table[0].length; col++) {
				printout += table[row][col] + " ";
			}
			printout += "\n";
		}
		System.out.println(printout);

		String symPairs = "Symmetric pairs\n";
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTableRows symrows = new SymmetricTableRows();
		symrows.findSymPairs(myTable);
	}

}
