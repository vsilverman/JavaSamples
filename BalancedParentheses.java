import java.util.Stack;
import java.util.Scanner;

/**
 *   This program finds if the input string,
 *   containing different types of 
 *   open and closing brackets,
 *   is balanced or not 
 */

/**
 * @author Vlad
 *
 */
public class BalancedParentheses {
	
    private static final char L1    = '(';
    private static final char R1    = ')';
    private static final char L2    = '{';
    private static final char R2    = '}';
    private static final char L3  = '[';
    private static final char R3  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        char curchar;
        for (int i = 0; i < s.length(); i++) {
        	curchar = s.charAt(i);
            if  (curchar == L1)
            	stack.push(L1);
            else if (curchar == L2)
            	stack.push(L2);
            else if (curchar == L3) 
            	stack.push(L3);

            else if (curchar == R1) {
                if (stack.isEmpty())
                	return false;
                if (stack.pop() != L1) 
                	return false;
            }

            else if (curchar == R2) {
                if (stack.isEmpty())
                	return false;
                if (stack.pop() != L2) 
                	return false;
            }

            else if (curchar == R3) {
                if (stack.isEmpty())
                	return false;
                if (stack.pop() != L3) 
                	return false;
            }

            // ignore all other characters

        }
        return stack.isEmpty();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method
        Scanner in = new Scanner(System.in);
        String s =  in.nextLine();
        while (!s.equals("done")) {
            System.out.println("String is balanced: " + isBalanced(s) + "\n");
            s =  in.nextLine();
        }
	}

}
