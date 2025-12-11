//Owen Nielsen, again
// I like turtles
/*
 * yet another coding project
 * Demonstrates handling two exceptions separately:
 *  - ArrayIndexOutOfBoundsException
 *  - ArithmeticException (divide by zero)
 * The program intentionally triggers each error inside its own try/catch,
 * prints a simple explanation, and continues so the program does not crash.
 */

public class YetAnotherCodingProject {
    public static void main(String[] args) {
        System.out.println("Starting 'yet another coding project' demo...");

        // 1) Array out-of-bounds demonstration
        int[] numbers = {10, 20, 30};
        try {
            // Intentionally access an invalid index to cause ArrayIndexOutOfBoundsException
            System.out.println("Accessing numbers[5] (this is out of bounds)...");
            int val = numbers[5];
            // This line will not run because the above access will throw
            System.out.println("Value: " + val);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Simple, user-friendly explanation
            System.out.println("Error: Tried to access an array element that doesn't exist.");
            System.out.println("Explanation: Arrays have fixed size — you tried to use an index outside that range.");
        }

        // Continue on to math problems
        System.out.println("Continuing to math operations...");

        // 2) Divide-by-zero demonstration
        try {
            System.out.println("Attempting to divide 10 by 0...");
            int a = 10;
            int b = 0;
            int result = a / b; // This will throw ArithmeticException
            // This line will not run
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero attempted.");
            System.out.println("Explanation: You tried to divide a number by zero, which is not allowed in integer arithmetic.");
        }

        // Final status
        System.out.println("All errors were caught. Program closed without crashing.");
    }
}
