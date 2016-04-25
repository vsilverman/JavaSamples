import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 This class allows executing external command 
 */

/**
 * @author Vlad
 *
 */
public class MyCommand1 {
	
	public static String[] envp = null; 
	public static File dir = null;
	public static String path ="c:\\curl-7.28.1\\src\\";
	public static String command = "curl.exe";
	public static String paramsKey = "InfoRequest::"; 
//	public static String params = "-i www.google.com";
	public static String params = "--help";
	public static String inFile = ".\\MyCommand.params";
	public static String outFile = ".\\MyCommand-Out.html";
	
	BufferedReader in, pInput;
//	PrintWriter out;
	
	public void exec(String cmd) {
		
		String sin = null;
		try {
/*			
			in = new BufferedReader(new FileReader(inFile));
*/			
//			out = new PrintWriter(new FileWriter(outFile));
/*			
			while ((sin = in.readLine()) != null) {
				if (sin.startsWith(paramsKey)) {
					params = sin.substring(paramsKey.length()+"::".length());
					break;
				}
			}
*/			
			System.out.println("Command: " + cmd);
			Process p = Runtime.getRuntime().exec(cmd, envp, dir);
//			Process p = Runtime.getRuntime().exec(cmdarray, envp, dir);

//*			
			pInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((sin = pInput.readLine()) != null) {
				System.out.println(sin);
//				out.println(sin);
			}
			pInput.close();
//			out.close();
//			in.close();
//*/
		}
		catch (IOException ioe) {
			System.out.println(ioe.getStackTrace());
			System.exit(-1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String MyCmd = path + command + " " + params;
		if (args.length < 1) {
			System.out.println("Usage: java MyCommand commandName");
			System.out.println("Running demo version with default params");
		}
		else {
			MyCmd = args[0];
//			paramsKey = args[1];
		}
		
		MyCommand1 mc = new MyCommand1();
		mc.exec(MyCmd);
	}

}
