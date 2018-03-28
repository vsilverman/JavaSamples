// -----------------------------------------------------------------------------
// GetOSName.java
// -----------------------------------------------------------------------------

 
/**
 * -----------------------------------------------------------------------------
 * This program demonstrates how to get the name of current operating system. The 
 * current operating system is the system from where the "java" command was invoked.
 * For Linux based systems the output should be "Linux".
 * For Windows 10 OS the output should be "Windows 10". 
 * -----------------------------------------------------------------------------
 */

public class GetOSName {

    private static void doGetOSName() {
        String currentOS = System.getProperty("os.name");
        System.out.println(currentOS);
    }

    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) {
        doGetOSName();
    }

}