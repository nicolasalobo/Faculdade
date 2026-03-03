/* Simple assert helper used by the test classes.  
   We don't use JUnit to keep tests runnable without additional setup.
*/

public class Assert {
    public static void assertTrue(String message, boolean condition) {
        if (!condition) throw new AssertionError(message);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected == null) {
            if (actual != null) throw new AssertionError(message + " - expected null, got: " + actual);
            return;
        }
        if (!expected.equals(actual)) throw new AssertionError(message + " - expected: " + expected + ", got: " + actual);
    }
}
