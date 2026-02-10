import java.io.*;
import java.util.*;

public class Part1_LetterFrequency {
    public static void main(String[] args) {
        String filename = "letter_frequency.txt";
        Map<String, Integer> frequencies = new TreeMap<>();
        int totalFrequency = 0;
        
        // Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Tokenize the line
                String[] tokens = line.split("\\s+");
                
                if (tokens.length == 2) {
                    String letter = tokens[0];
                    int frequency = Integer.parseInt(tokens[1]);
                    frequencies.put(letter, frequency);
                    totalFrequency += frequency;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found.");
            System.out.println("Please make sure the file is in the same directory as this program.");
            return;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        // Calculate and print results
        double totalPercentage = 0;
        double averageFrequency = 0;
        
        if (!frequencies.isEmpty()) {
            averageFrequency = (double) totalFrequency / frequencies.size();
            
            // Print each letter with its frequency and percentage
            for (String letter : frequencies.keySet()) {
                int frequency = frequencies.get(letter);
                float percentage = (float) frequency / totalFrequency * 100;
                totalPercentage += percentage;
                
                System.out.println(letter + "\t" + frequency + "\t" + String.format("%.2f%%", percentage));
            }
            
            // Print total line
            System.out.println("---\t---\t---");
            System.out.println("Total" + "\t" + String.format("%.2f", averageFrequency) + "\t" + 
                             String.format("%.2f%%", totalPercentage));
        }
    }
}
