import java.util.Scanner;

/**
 * KeyboardInputDemo
 * - Prompts user for an int, a float, and a line of text.
 * - Validates input using try/catch and repeats the prompt until valid.
 * - Demonstrates reading a full name (first and last) as one input and
 *   printing greetings: "Hello, Mr/Ms <last>" and "Can I call you <first>?"
 */
public class KeyboardInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int anInt = readInt(sc, "Please enter an integer:");
        System.out.println("Thank you for inputing the int, I read " + anInt + ".");

        float aFloat = readFloat(sc, "Please enter a floating-point number:");
        System.out.println("Thank you for inputing the float, I read " + aFloat + ".");

        String aLine = readLine(sc, "Please enter a line of text:");
        System.out.println("Thank you for inputing the line, I read: \"" + aLine + "\".");

        // Part 2: read full name and try to split into first/last
        System.out.println();
        System.out.println("Now for the name test (not strictly graded):");
        String fullName = readLine(sc, "Please enter your full name (first and last):");

        // Split on whitespace
        String firstName = "";
        String lastName = "";
        if (fullName.trim().isEmpty()) {
            System.out.println("No name entered.");
        } else {
            String[] parts = fullName.trim().split("\\s+");
            if (parts.length == 1) {
                firstName = parts[0];
                System.out.println("Hello, " + firstName + ". I couldn't find a last name.");
            } else {
                firstName = parts[0];
                // Last name is everything after the first token so compound last names are handled
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < parts.length; i++) {
                    if (i > 1) sb.append(' ');
                    sb.append(parts[i]);
                }
                lastName = sb.toString();

                // Ask preference for Mr or Ms (optional)
                String salutation = readLineOptional(sc, "If you prefer, type Mr or Ms to be used in the greeting (or press Enter to skip):");
                if (salutation.equalsIgnoreCase("Mr") || salutation.equalsIgnoreCase("Ms")) {
                    System.out.println("Hello, " + salutation + " " + lastName + ".");
                } else {
                    System.out.println("Hello, " + lastName + ".");
                }
                System.out.println("Can I call you " + firstName + "?");
            }
        }

        System.out.println("Program finished. Thanks for testing input handling.");
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("That wasn't a valid integer. Please try again.");
            }
        }
    }

    private static float readFloat(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            String line = sc.nextLine();
            try {
                return Float.parseFloat(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("That wasn't a valid floating-point number. Please try again.");
            }
        }
    }

    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt + " ");
        return sc.nextLine();
    }

    private static String readLineOptional(Scanner sc, String prompt) {
        System.out.print(prompt + " ");
        return sc.nextLine().trim();
    }
}