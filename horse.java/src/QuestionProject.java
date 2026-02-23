import java.io.*;
import java.util.*;

public class QuestionProject {

    static class Record {
        String name;
        double age;
        String zip;
        String city;
        String pet;

        Record(String name, double age, String zip, String city, String pet) {
            this.name = name;
            this.age = age;
            this.zip = zip;
            this.city = city;
            this.pet = pet;
        }

        String toFileLine() {
            return String.join("|", name, Double.toString(age), zip, city, pet);
        }

        static Record fromFileLine(String line) {
            String[] parts = line.split("\\|", -1);
            if (parts.length < 5) return null;
            double a;
            try { a = Double.parseDouble(parts[1]); } catch (NumberFormatException e) { a = 0; }
            return new Record(parts[0], a, parts[2], parts[3], parts[4]);
        }
    }

    public static void main(String[] args) {
        final int RECORD_COUNT = 5;
        String outFile = "questionproject.txt";

        Scanner in = new Scanner(System.in);
        List<Record> records = new ArrayList<>();

        System.out.println("QuestionProject - Please enter data for " + RECORD_COUNT + " people.");

        for (int i = 1; i <= RECORD_COUNT; i++) {
            System.out.println();
            System.out.println("Record " + i + " of " + RECORD_COUNT + ":");

            System.out.print("Full name: ");
            String name = in.nextLine().trim();
            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Full name: ");
                name = in.nextLine().trim();
            }

            double age = 0;
            while (true) {
                System.out.print("Age (years, can be decimal): ");
                String ageStr = in.nextLine().trim();
                try {
                    age = Double.parseDouble(ageStr);
                    if (age < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid non-negative number for age.");
                }
            }

            System.out.print("ZIP code: ");
            String zip = in.nextLine().trim();
            while (zip.isEmpty()) {
                System.out.print("ZIP cannot be empty. ZIP code: ");
                zip = in.nextLine().trim();
            }

            System.out.print("City: ");
            String city = in.nextLine().trim();
            if (city.isEmpty()) city = "(none)";

            System.out.print("Favorite pet: ");
            String pet = in.nextLine().trim();
            if (pet.isEmpty()) pet = "(none)";

            Record r = new Record(name, age, zip, city, pet);
            records.add(r);

            // Append record to file so progress is saved incrementally
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile, true))) {
                bw.write(r.toFileLine());
                bw.newLine();
            } catch (IOException e) {
                System.err.println("Failed to write record to file: " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("All records saved to " + outFile + ". Reading back and printing formatted output...\n");

        // Read file and parse records
        List<Record> readRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(outFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                Record rr = Record.fromFileLine(line);
                if (rr != null) readRecords.add(rr);
            }
        } catch (IOException e) {
            System.err.println("Failed to read records: " + e.getMessage());
            return;
        }

        // Print header
        System.out.println("============================================");
        System.out.println("QuestionProject - Collected Records");
        System.out.println("============================================");
        System.out.printf("%-3s %-25s %-6s %-8s %-15s %-15s%n", "#", "Name", "Age", "ZIP", "City", "Favorite Pet");
        System.out.println("--------------------------------------------------------------------------------");

        double sumAge = 0;
        Map<String, Integer> zipCounts = new HashMap<>();

        int idx = 1;
        for (Record rec : readRecords) {
            System.out.printf("%-3d %-25s %6.2f %-8s %-15s %-15s%n",
                    idx, rec.name, rec.age, rec.zip, rec.city, rec.pet);
            sumAge += rec.age;
            zipCounts.put(rec.zip, zipCounts.getOrDefault(rec.zip, 0) + 1);
            idx++;
        }

        System.out.println();
        double avgAge = readRecords.isEmpty() ? 0 : sumAge / readRecords.size();

        // Find mode of zip codes
        String modeZip = "(none)";
        int modeCount = 0;
        for (Map.Entry<String, Integer> e : zipCounts.entrySet()) {
            if (e.getValue() > modeCount) {
                modeCount = e.getValue();
                modeZip = e.getKey();
            }
        }

        System.out.printf("Average age: %.2f years\n", avgAge);
        if (modeCount > 0) {
            System.out.printf("Most common ZIP code: %s (appeared %d times)\n", modeZip, modeCount);
        } else {
            System.out.println("Most common ZIP code: (none)");
        }

        System.out.println("\nThank you — QuestionProject finished.");
    }
}
