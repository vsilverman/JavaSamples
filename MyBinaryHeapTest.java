import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;


/**
 * 
 */

/**
 * @author Vlad
 *
 */
public class MyBinaryHeapTest {
	
	private static final int[] TEST_DATA = {1, 3, 7, 5, 15, 9, 20, 10, 12};

	
	
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method
	 */
	@Test
	public void test1() {
		
	}
	
    @Test
    public void t1() {
		MyBinaryHeap history = new MyBinaryHeap();
		MyBinaryHeap latest = new MyBinaryHeap();
		for (int i : TEST_DATA) {
			history.add(i);
			latest.add(i);
		}
		
		int[] input = {6, 16, 11, 14, 2};
		for (int i : input) {
			System.out.println("Adding " + i);
			history.add(i);
			latest.replaceMinValue(i);
		}
		Arrays.sort(history.getData(), 1, history.getSize()+1, Collections.reverseOrder());
		Arrays.sort(latest.getData(), 1, latest.getSize()+1, Collections.reverseOrder());
		System.out.println("history: " + history.toString());
		System.out.println("latest: " + latest.toString());
		assertTrue(history.getData()[1]==latest.getData()[1]);
    	
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinaryHeap mbh = new MyBinaryHeap();


	}

}
