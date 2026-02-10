import java.io.*;
import java.util.*;

public class UserDataCollector {
    private static final String DATA_FILE = "user_data.txt";
    private static final String[] FIELD_NAMES = {"Name", "Address", "City", "State", "Phone"};
    private static final int NUM_USERS = 5;
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        // Part 1: Collect user data and save to file
        System.out.println("=== User Data Collection ===\n");
        collectAndSaveUserData(userInput);
        
        // Part 2: Read and parse the data from file
        System.out.println("\n=== Displaying Parsed Data ===\n");
        readAndParseUserData();
        
        userInput.close();
    }
    
    // Collect data from user and save to file
    private static void collectAndSaveUserData(Scanner userInput) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            
            for (int userNum = 1; userNum <= NUM_USERS; userNum++) {
                System.out.println("--- User " + userNum + " ---");
                StringBuilder userData = new StringBuilder();
                
                for (int fieldNum = 0; fieldNum < FIELD_NAMES.length; fieldNum++) {
                    System.out.print(FIELD_NAMES[fieldNum] + " for user " + userNum + ": ");
                    String input = userInput.nextLine().trim();
                    
                    if (fieldNum > 0) {
                        userData.append("|");
                    }
                    userData.append(input);
                }
                
                writer.println(userData.toString());
                System.out.println();
            }
            
            System.out.println("Data saved to " + DATA_FILE);
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    // Read and parse the data from file
    private static void readAndParseUserData() {
        try (Scanner fileScanner = new Scanner(new File(DATA_FILE))) {
            
            int userNum = 1;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                
                if (line.isEmpty()) {
                    continue;
                }
                
                System.out.println("User " + userNum + ":");
                
                // Parse the line using pipe delimiter
                String[] fields = line.split("\\|");
                
                for (int i = 0; i < fields.length && i < FIELD_NAMES.length; i++) {
                    System.out.println("  " + FIELD_NAMES[i] + ": " + fields[i]);
                }
                
                System.out.println();
                userNum++;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Data file not found. Please run data collection first.");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
