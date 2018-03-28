// -----------------------------------------------------------------------------
// GetAllSysProperties.java
// -----------------------------------------------------------------------------

 
/**
 * -----------------------------------------------------------------------------
 * This program demonstrates how to get all system properties.
 * -----------------------------------------------------------------------------
 */

public class GetAllSysProperties {

    private static void doGetAllSysProperties() {
        System.getProperties().list(System.out);
    }

    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) {
        doGetAllSysProperties();
    }

}