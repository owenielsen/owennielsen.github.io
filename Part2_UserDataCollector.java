import java.io.*;
import java.util.*;

public class Part2_UserDataCollector {
    private static final String[] FIELD_NAMES = {"Name", "Address", "City", "State", "Zip", "Phone Number"};
    private static final String OUTPUT_FILE = "user_data.txt";
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== User Data Collector ===\n");
        
        // Part 1: Collect data from user
        collectAndSaveUserData();
        
        // Part 2: Read and parse the data
        System.out.println("\n=== Reading and Parsing Saved Data ===\n");
        readAndParseData();
    }
    
    private static void collectAndSaveUserData() {
        List<String[]> allUserData = new ArrayList<>();
        
        // Collect 5 different times for 5 items of data
        for (int iteration = 1; iteration <= 5; iteration++) {
            String[] userData = new String[FIELD_NAMES.length];
            
            for (int fieldIndex = 0; fieldIndex < FIELD_NAMES.length; fieldIndex++) {
                System.out.print(FIELD_NAMES[fieldIndex] + " for user " + iteration + ": ");
                userData[fieldIndex] = scanner.nextLine().trim();
            }
            
            allUserData.add(userData);
            System.out.println("User " + iteration + " data saved.\n");
        }
        
        // Save to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            for (String[] userData : allUserData) {
                // Use a special delimiter that's unlikely to appear in user input
                // Using "||" as delimiter since user input won't likely contain this
                writer.println(String.join("||", userData));
            }
            System.out.println("Data saved to " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    private static void readAndParseData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
            String line;
            int userNumber = 1;
            
            while ((line = reader.readLine()) != null) {
                System.out.println("--- User " + userNumber + " ---");
                
                // Split by our delimiter
                String[] fields = line.split("\\|\\|");
                
                for (int i = 0; i < fields.length && i < FIELD_NAMES.length; i++) {
                    System.out.println(FIELD_NAMES[i] + ": " + fields[i]);
                }
                
                System.out.println();
                userNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
