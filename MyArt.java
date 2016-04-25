import java.io.File;

/**
 * 
 */

/**
 * -----------------------------------------------------------------------------
 * This program demonstrates the work of automated remote tool-chain (ART) framework.
 * 
 * @version 1.0
 * @author  Vlad
 * @author  (vsilverman@yahoo.com)
 * @author  http://www.yahoo.com
 * -----------------------------------------------------------------------------
 *
 */
public class MyArt {
	
	private static MyProperties myProps = new MyProperties();
	private static MyCommand1 mc = new MyCommand1();
//	private static String dirName = null;
	private static String dirName = "d:\\Flash1\\SVA\\R\\V\\2016";
	private static String cmdName = "call-from-java.cmd";
	
	private static void publish(String artProps) {
		MyProperties.propsFileName = artProps;
		myProps.loadAndPrint();
		dirName = MyProperties.props.getProperty("art.folder");
		cmdName = MyProperties.props.getProperty("art.script");
		
		traverse(new File(dirName));
	}

    private static void processDir(File dir) {
        System.out.print( (dir.isDirectory() ? "[D] : " : "[F] : "));
        System.out.println(dir);
    }

    private static void traverse(File dir) {
        processDir(dir);

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                traverse(new File(dir, children[i]));
            }
        }
        else {
        	String fileName = dir.toString();
        	int pos = fileName.lastIndexOf("\\");
        	String scriptName = fileName.substring(pos + 1);
        	if (scriptName.equals(cmdName)) {
            	mc.exec(fileName);
        	}
        }

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    	String PropFile = "d:\\Flash1\\SVA\\R\\V\\2016\\art.cfg"; 
    	String PropFile = "c:\\bin\\art.cfg"; 
		if (args.length < 1) {
			System.out.println("Usage: java MyArt PropFile");
			System.out.println("Running demo version with default params");
		}
		else {
			PropFile = args[0];
		}

		MyArt.publish(PropFile);
	}

}
