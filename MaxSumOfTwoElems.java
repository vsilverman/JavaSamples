import java.util.ArrayList;
import java.util.Arrays;

/**
 *  This program finds max sum of 2 elements
 *  from the array list of integer numbers  
 *  
 *  TODO:
 *  -----
 *  Provided solution doesn't handle couple cases:
 *  
 *  - sum of 2 large negative numbers is greater than
 *    the sum of any 2 positive numbers in the sequence
 *    (as possible solution the original input may be 
 *    split into the sequence of positive and negative
 *    numbers, max sum will be found separately for
 *    every sequence and compared with each other to
 *    determine the absolute maximum sum) 
 *    
 *  - sum of 2 large numbers is greater than Integer.MAX_VALUE
 *    (as possible solution the return type of the function 
 *    may be changed to double)  
 *  
 */

/**
 * @author Vlad
 *
 */
public class MaxSumOfTwoElems {
	public static final ArrayList<Integer> DEFAULT_INPUT = new ArrayList<Integer>(Arrays.asList(30, 6, 50, 21, 49, -101, 7, -1)); 

	public int findMaxSum(ArrayList<Integer> input) throws Exception {
        if (input == null || input.size() == 1) {
                throw new Exception("Incorrect parameter values are passed");
        }
        else {
        	int res ;
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE + 1;  // to make sure that max1 > max2
            for (int i=0; i < input.size(); i++) {
            	if (input.get(i) > max1) {
            		max2 = max1;
                    max1 = input.get(i);
                }
                else if (max2 < input.get(i)) {
                    max2 = input.get(i);
                }
            }
            res = max1 + max2;
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
			int ms = msum.findMaxSum(input);
			System.out.println("Maximum sum:\t" + ms);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
