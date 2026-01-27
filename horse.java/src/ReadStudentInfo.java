import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program reads student information from the "student.txt" file
 * and prints it to the console as strings (lines), not individual characters.
 * 
 * The file contains three lines of student data:
 * - First name
 * - Last name
 * - Academic year
 * - School name
 */
public class ReadStudentInfo {

    /**
     * Main method that reads from the student.txt file and prints to console.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader fileReader = new BufferedReader(new FileReader("student.txt"))) {
            
            // Read and print the first line (first name)
            String firstName = fileReader.readLine();
            System.out.println("First Name: " + firstName);
            
            // Read and print the second line (last name)
            String lastName = fileReader.readLine();
            System.out.println("Last Name: " + lastName);
            
            // Read and print the third line (academic year)
            String academicYear = fileReader.readLine();
            System.out.println("Academic Year: " + academicYear);
            
            // Read and print the fourth line (school name)
            String schoolName = fileReader.readLine();
            System.out.println("School Name: " + schoolName);
            
            System.out.println("\nStudent information has been read successfully from student.txt");
            
        } catch (IOException exception) {
            // Handle any IO exceptions that may occur during file reading
            System.err.println("An error occurred while reading from the file: " + exception.getMessage());
        }
    }
}
