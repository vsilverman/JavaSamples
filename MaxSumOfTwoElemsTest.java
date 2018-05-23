import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *  This program provides unit tests for
 *  method of finding max sum of 2 elements
 *  from the array list of integer numbers.
 *  
 *  Above method tested here is defined 
 *  inside MaxSumOfTwoElems class.  
 *  
 */


/**
 * @author Vlad
 *
 */
public class MaxSumOfTwoElemsTest {
	
	public static ArrayList<Integer> testInput = new ArrayList<Integer>();
	MaxSumOfTwoElems msum;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		msum = new MaxSumOfTwoElems();
		testInput.clear();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test sequence of positive numbers
	 */
    @Test
    public void test1() throws Exception {
		int[] newData = {1, 2, 3};
		int expectedMax = 5;
		String failMsg = "Failed for Sequence of positive numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence of negative numbers
	 */
    @Test
    public void test2() throws Exception {
		int[] newData = {-1, -2, -10};
		int expectedMax = -3;
		String failMsg = "Failed for Sequence of negative numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence of same numbers
	 */
    @Test
    public void test3() throws Exception {
		int[] newData = {1, 2, 2};
		int expectedMax = 4;
		String failMsg = "Failed for Sequence of same numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test long sequence of positive numbers
	 */
    @Test
    public void test4() throws Exception {
		int[] newData = {30, 6, 50, 21, 17, 23, 10, 18, 32, 15, 49, 4, 45};
		int expectedMax = 99;
		String failMsg = "Failed for long Sequence of positive numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test the empty data
	 */
    @Test
    public void test5() {
    	String exMsg = "";
    	int[] newData = {};
		String failMsg = "Failed for empty data";
    	try {
    		setTestInput(newData);
    		msum.findMaxSum(testInput);
    	}
    	catch (Exception e) {
    		exMsg = e.getMessage();
    		assertTrue(failMsg, exMsg.length() > 0);
    	}

    }
    

	/**
	 * Test zeros in sequence of numbers
	 */
    @Test
    public void test6() throws Exception {
		int[] newData = {22, 0, 11, 0, 33};
		int expectedMax = 55;
		String failMsg = "Failed for zeros in Sequence of numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence of positive and negative numbers
	 */
    @Test
    public void test7() throws Exception {
		int[] newData = {-22, 10, -11, -10, 33};
		int expectedMax = 43;
		String failMsg = "Failed for Sequence of positive and negative numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence of random numbers
	 */
    @Test
    public void test8() throws Exception {
		int[] newData = new int[10];
		for (int i=0; i<newData.length; i++) {
			newData[i] = new Random().nextInt(50);
		}
		String failMsg = "Failed for Sequence of random numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput) > 1);
    }
    

	/**
	 * Test sequence of very large negative numbers
	 */
    @Test
    public void test9() throws Exception {
		int[] newData = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		long expectedMax = -4294967296L;
		String failMsg = "Failed for very large negative numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence of very large positive numbers
	 */
    @Test
    public void test10() throws Exception {
		int[] newData = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		long expectedMax = 4294967294L;
		String failMsg = "Failed for very large positive numbers";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

	/**
	 * Test sequence, where maximum sum is zero
	 */
    @Test
    public void test11() throws Exception {
		int[] newData = {-12, 12};
		int expectedMax = 0;
		String failMsg = "Failed for sequence, where maximum sum is zero";

		setTestInput(newData);
		assertTrue(failMsg, msum.findMaxSum(testInput)==expectedMax);
    }
    

    /**
	 * setTestInput
	 */
    private void setTestInput(int[] data) {
		for (int i : data) {
			testInput.add(i);
		}
    }


}
