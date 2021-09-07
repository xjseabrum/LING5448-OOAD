// Written using Java JDK v. 16.

/* codeToType takes in an integer from the asciiCode int array list
 * checks it against various cases to assign it the
 * appropriate character type.
 */

/* These are the following types that need to be accounted for
 * (endpoints inclusive set notation):
 *
 * Lowercase: [97, 122]
 * Uppercase: [65, 90]
 * Digit: [48, 57]
 * Whitespace: {0, 9, 11, 12, 13, 14, 32}
 * Special Character: all other ASCII values.
 */

// Checking if value in array taken from:
// https://www.geeksforgeeks.org/check-if-a-value-is-present-in-an-array-in-java/

public class codeToType {
    public static String typeName;

    private static final int[] whitespace =
            new int[]{0, 9, 11, 12, 13, 14, 32};

    public static void output(int var2) {
        for (int i : whitespace) {
            if (i == var2) {
                typeName = "Whitespace";
                break;
            } else if (var2 >= 97 && var2 <= 122) {
                typeName = "Lowercase";
            } else if (var2 >= 65 && var2 <= 90) {
                typeName = "Uppercase";
            } else if (var2 >= 48 && var2 <= 57) {
                typeName = "Digit";
            } else {
                typeName = "Special Character";
            }
        }
        System.out.print(" Type: " + typeName + "\t");
    }
}
