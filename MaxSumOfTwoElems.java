import java.util.ArrayList;
import java.util.Arrays;

/**
 *  This program finds max sum of 2 elements
 *  from the array list of integer numbers  
 *  
 */

/**
 * @author Vlad
 *
 */
public class MaxSumOfTwoElems {
	public static final ArrayList<Integer> DEFAULT_INPUT = new ArrayList<Integer>(Arrays.asList(30, 6, 50, 21, 49, -101, 7, -1)); 

	public long findMaxSum(ArrayList<Integer> input) throws Exception {
        if (input == null || input.size() == 1) {
                throw new Exception("Incorrect parameter values are passed");
        }
        else {
        	long res=0;
        	int max1=Integer.MIN_VALUE;
        	int max2=Integer.MIN_VALUE;
            for (Integer i : input) {
            	if (i >= max1) {
            		max2 = max1;
            		max1 = i;
            	}
            	else if (i >= max2) {
                	max2 = i;
            	}
            }
            res = Long.sum(max1, max2);
            return res;
        }
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Integer> input = DEFAULT_INPUT; 
			MaxSumOfTwoElems msum = new MaxSumOfTwoElems();
			if (args.length > 0) {
				for (String s : args) {
					input.add(Integer.parseInt(s));
				}
			}
			System.out.println("Input numbers:\t" + input.toString());
			long ms = msum.findMaxSum(input);
			System.out.println("Maximum sum:\t" + ms);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
