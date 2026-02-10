import java.io.*;
import java.util.*;

public class LetterFrequencyAnalyzer {
    public static void main(String[] args) {
        String filename = "letter_frequency.txt";
        
        try {
            // Read the file and store the data
            Scanner scanner = new Scanner(new File(filename));
            
            Map<String, Integer> frequencies = new HashMap<>();
            int totalFrequency = 0;
            
            // Read and parse the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                
                // Split the line to extract letter and frequency
                String[] parts = line.split("\\s+");
                
                if (parts.length >= 2) {
                    String letter = parts[0];
                    int frequency = Integer.parseInt(parts[1]);
                    
                    frequencies.put(letter, frequency);
                    totalFrequency += frequency;
                }
            }
            scanner.close();
            
            // Calculate and display results
            if (frequencies.isEmpty()) {
                System.out.println("No data found in file");
                return;
            }
            
            float totalPercentage = 0f;
            float averageFrequency = 0f;
            
            System.out.println("Letter\tFrequency\tPercentage");
            System.out.println("------\t---------\t----------");
            
            // Print each letter with its data
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                String letter = entry.getKey();
                int frequency = entry.getValue();
                float percentage = (frequency * 100.0f) / totalFrequency;
                
                totalPercentage += percentage;
                
                System.out.printf("%s\t%d\t\t%.2f%%\n", letter, frequency, percentage);
            }
            
            // Calculate average frequency
            if (!frequencies.isEmpty()) {
                averageFrequency = totalFrequency / (float) frequencies.size();
            }
            
            // Print total line
            System.out.println("------\t---------\t----------");
            System.out.printf("Total\t%.2f\t\t%.2f%%\n", averageFrequency, totalPercentage);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found.");
            System.out.println("Please download the letter frequency file and place it in the same directory as this program.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in file. Make sure frequencies are integers.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
