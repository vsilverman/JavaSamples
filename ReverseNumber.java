import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import java.util.Random;



/**
 *  This program provides a method
 *  to reverse the integer number
 *  
 *  Program includes also several
 *  JUnit tests for this method.
 */

/**
 * @author Vlad
 *
 */
public class ReverseNumber {
	
	public long reverse(int n) {
		long res = 0;
		int rem = 0;
		while (n > 0) {
			rem = n % 10;
			n = n / 10;
			res = res*10 + rem;
		}
		return res;
	}

	
	@BeforeClass
	public static void setUpBeforeClass() {
	}

	/**
	 * 
	 */
	@AfterClass
	public static void tearDownAfterClass() {
	}

	/**
	 * 
	 */
	@Before
	public void setUp() {
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
	}

	/**
	 * Test reversing a zero
	 */
    @Test
    public void test1() {
		int testNmb = 0;
		int expectedRes = 0;
		String failMsg = "Failed reversing a zero";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * Test one-digit numbers
	 */
    @Test
    public void test2() {
		int testNmb = 7;
		int expectedRes = 7;
		String failMsg = "Failed for one-digit numbers";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * Test two-digit numbers
	 */
    @Test
    public void test3() {
		int testNmb = 35;
		int expectedRes = 53;
		String failMsg = "Failed for two-digit numbers";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * Test two-digit numbers with same digits
	 */
    @Test
    public void test4() {
		int testNmb = 44;
		int expectedRes = 44;
		String failMsg = "Failed for two-digit numbers with same digits";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * Test three-digit numbers ending with zero
	 */
    @Test
    public void test5() {
		int testNmb = 800;
		int expectedRes = 8;
		String failMsg = "Failed for three-digit numbers ending with zero";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * Test max int number
	 */
    @Test
    public void test6() {
		int testNmb = Integer.MAX_VALUE; // = 2147483647
		long expectedRes = 7463847412L;
		String failMsg = "Failed for max int number";

		assertTrue(failMsg, reverse(testNmb)==expectedRes);
    }
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int orgNmb = 2018;
		System.out.println("Original number = " + orgNmb);
		ReverseNumber rn = new ReverseNumber();
		long revNmb = rn.reverse(orgNmb);
		System.out.println("Reversed number = " + revNmb);
	}

}
