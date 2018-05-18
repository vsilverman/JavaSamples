import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *  This program tests MyBinaryHeap.java methods,
 *  allowing adding to the binary heap the data
 *  from the input stream of integer numbers and
 *  keep in it the 10 largest numbers from all
 *  numbers, supplied by the input data stream.
 */

/**
 * @author Vlad
 *
 */
public class MyBinaryHeapTest {
	
	private static final int[] TEST_DATA = {1, 3, 7, 5, 15, 9, 20, 10, 12};
	MyBinaryHeap history, latest;
	
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
		history = new MyBinaryHeap();
		latest = new MyBinaryHeap();
		for (int i : TEST_DATA) {
			history.add(i);
			latest.add(i);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test adding sequence
	 */
    @Test
    public void test1() {
		int[] newData = {6, 16, 11, 14, 2};
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()]==latest.getData()[latest.getSize()]);
    }
    
	/**
	 * Test adding zero
	 */
    @Test
    public void test2() {
		int[] newData = {0};
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()]==latest.getData()[latest.getSize()]);
    }
    
	/**
	 * Test adding negative number
	 */
    @Test
    public void test3() {
		int[] newData = {-1};
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()]==latest.getData()[latest.getSize()]);
    }
    

	/**
	 * Test adding max int number = 2147483647 
	 */
    @Test
    public void test4() {
		int[] newData = {Integer.MAX_VALUE};
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()]==latest.getData()[latest.getSize()]);
    }
    
    
	/**
	 * Test adding sequence of same number
	 */
    @Test
    public void test5() {
		int[] newData = {777, 777, 777};
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()].equals(latest.getData()[latest.getSize()]));
    }
    
    
	/**
	 * Test adding sequence of random numbers
	 */
    @Test
    public void test6() {
    	int dataSize = 10;
    	int[] newData = new int[dataSize];
    	for (int i=0; i<dataSize; i++) {
    		newData[i] = new Random().nextInt(20);
    	}
		processInput(newData);
		assertTrue(history.getData()[1].equals(latest.getData()[1]));
		assertTrue(history.getData()[latest.getSize()].equals(latest.getData()[latest.getSize()]));
    }
    
    
    /**
	 * processInput
	 */
    private void processInput(int[] input) {
		for (int i : input) {
			System.out.println("Adding " + i);
			history.add(i);
			latest.replaceMinValue(i);
		}
		Arrays.sort(history.getData(), 1, history.getSize()+1, Collections.reverseOrder());
		Arrays.sort(latest.getData(), 1, latest.getSize()+1, Collections.reverseOrder());
		System.out.println("history: " + history.toString());
		System.out.println("latest: " + latest.toString());
    }

}
