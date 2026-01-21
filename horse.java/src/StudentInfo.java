import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program collects student information from the user via keyboard input
 * and writes it to a file named "student.txt". The information includes:
 * - First and last name
 * - Academic year (e.g., 9th grade, freshman)
 * - School name
 *
 * The program uses streams for file writing and ensures proper resource management.
 */
public class StudentInfo {

    /**
     * Main method that executes the program logic.
     * Prompts user for input and writes to file.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner keyboardInput = new Scanner(System.in);

        // Prompt user for first name
        System.out.print("Enter your first name: ");
        String firstName = keyboardInput.nextLine();

        // Prompt user for last name
        System.out.print("Enter your last name: ");
        String lastName = keyboardInput.nextLine();

        // Prompt user for academic year
        System.out.print("Enter your academic year (e.g., 9th grade, freshman): ");
        String academicYear = keyboardInput.nextLine();

        // Prompt user for school name
        System.out.print("Enter the name of your school: ");
        String schoolName = keyboardInput.nextLine();

        // Close the scanner to free resources
        keyboardInput.close();

        // Use try-with-resources to automatically close the PrintWriter
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter("student.txt"))) {
            // Write the collected information to the file, one piece per line
            fileWriter.println(firstName);
            fileWriter.println(lastName);
            fileWriter.println(academicYear);
            fileWriter.println(schoolName);

            // Inform the user that the information has been written successfully
            System.out.println("Student information has been written to student.txt");
        } catch (IOException exception) {
            // Handle any IO exceptions that may occur during file writing
            System.err.println("An error occurred while writing to the file: " + exception.getMessage());
        }
    }
}