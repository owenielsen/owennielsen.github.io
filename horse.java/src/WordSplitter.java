import java.util.Scanner;

public class WordSplitter {

    private static String[] splitIntoWords(String text) {
        if (text == null || text.trim().isEmpty()) return new String[0];
        // Remove punctuation except apostrophes, keep letters and numbers and spaces
        String cleaned = text.replaceAll("[^\\p{L}\\p{Nd}\\s']+", "");
        cleaned = cleaned.trim().replaceAll("\\s+", " ");
        if (cleaned.isEmpty()) return new String[0];
        return cleaned.split(" ");
    }

    private static void printWordsAndCount(String text) {
        String[] words = splitIntoWords(text);
        for (String w : words) {
            System.out.println(w);
        }
        System.out.println("Total words: " + words.length);
    }

    public static void main(String[] args) {
        String testString = "the quick Brown Fox Jumped over the lazy dog";

        System.out.println("Hard-coded string:");
        printWordsAndCount(testString);

        System.out.println();
        System.out.println("Enter a line of text:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("\nUser input:");
        printWordsAndCount(input);

        scanner.close();
    }
}
