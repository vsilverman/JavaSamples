import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.ExpectedException;

/**
 * @author Vlad S.
 *
 */
public class StringUtil {
	
	public static String longStr = "ABCABCD";

    /**
     * Returns the first occurrence of short_string in long_string
     * as a 0 based index into long_string. 
     * If short_string does not exist in long_string, the function
     * returns -1.
     *
     * @return  the first occurrence of short_string in long_string
     * 
     */
	public static int strstr(String shortStr, String longStr) throws Exception {
		int result = -1;
		int shortLen = shortStr.length();
		int longLen = longStr.length();
		if (shortStr.length() * longStr.length() == 0)
			throw new Exception ("strstr() should have valid string parameters");
		char ch = shortStr.charAt(0);
		for (int i=0, j=0; i<longLen ;) {
			while (ch != longStr.charAt(i)) {
				if (++i == longLen)
					return -1;
			}
			result=i;  // save the index
			for(j=0;j<shortLen && longStr.charAt(i)==shortStr.charAt(j);i++,j++) {}
			if (j==shortLen) 
				return result;
		}
		return result;
	}

	/** main test() function */
	public static boolean test() throws Exception {
		if (test1()&&test2()&&test3()&&test4()&&test5()&&test6()&&test7()&&test8())
			return true;
		else
			return false;
	}
	
	/** private testing function */
	private static boolean test1() throws Exception {
		if (strstr("A", longStr) == 0)
			return true;
		else
			return false;
	}
			
	/** private testing function */
	private static boolean test2() throws Exception {
		if (strstr("ABC", longStr) == 0)
			return true;
		else
			return false;
	}
				
	/** private testing function */
	private static boolean test3() throws Exception {
		if (strstr("ABCD", longStr) == 3)
			return true;
		else
			return false;
	}			
		
	/** private testing function */
	private static boolean test4() throws Exception {
		if (strstr("CD", longStr) == 5)
			return true;
		else
			return false;
	}			
		
	/** private testing function */
	private static boolean test5() throws Exception {
		if (strstr("BC", longStr) == 1)
			return true;
		else
			return false;
	}			
		
	/** private testing function */
	private static boolean test6() throws Exception {
		if (strstr("C", longStr) == 2)
			return true;
		else
			return false;
	}			
		
	/** private testing function */
	private static boolean test7() throws Exception {
		if (strstr("D", longStr) == 6)
			return true;
		else
			return false;
	}			
		
	/** private testing function */
	private static boolean test8() throws Exception {
		if (strstr("Y", longStr) == -1)
			return true;
		else
			return false;
	}			
		
	

	/**
	 * main() method
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (test()==true)
			System.out.println("*** strstr() testing is completed OK ***");
		else
			System.out.println("... strstr() testing failed ...");
	}

	
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
	 * Test method for {@link StringUtil#strstr(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStrstr() {
		try {
			int res = strstr("BC", "ABCABCD"); 
			assertEquals(1, res);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Test method for {@link StringUtil#test()}.
	 */
	@Test
	public void testTest() {
		try {
			assertTrue(test());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Test method for {@link StringUtil#test1()}.
	 */
	@Test
	public void testTest1() throws Exception {
		assertEquals(0, strstr("A", longStr));
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
//	@Test
//	public void throwsIllegalArgumentExceptionIfBothNull() throws Exception {
//	    exception.expect(IllegalArgumentException.class);
//	    exception.expectMessage("strstr() should have valid string parameters");
//	    strstr("", "");
//	  }
	

//	@Test
//	public void testUsingTempFolder() throws IOException {
//	    File myFolder = tempFolder.newFolder("d:\\Flash1\\dev\\myTempFolder"); // this folder will be removed after the test
//	    File myFile = tempFolder.newFile("myTempFile.txt"); // this file will be removed after the test
//	    assertTrue(myFolder.exists());
//	    assertTrue(myFile.exists());
//	  }


}
