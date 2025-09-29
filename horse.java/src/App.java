public class App {
    public static void main(String[] args) {
        // create a few Horse objects using the constructor that takes a name and birth year
        Horse horse1 = new Horse("dumb", 2018);
        Horse horse2 = new Horse("dumber", 2015);
        Horse horse3 = new Horse("dumbest", 2022);

        // allow optional year argument: java App 2025
        int currentYear;
        if (args.length >= 1) {
            try {
                currentYear = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid year argument, using system year.");
                currentYear = java.time.Year.now().getValue();
            }
        } else {
            currentYear = java.time.Year.now().getValue();
        }

        System.out.println("Current year: " + currentYear);
        System.out.println("--- Horse ages ---");
        printHorse(horse1, currentYear);
        printHorse(horse2, currentYear);
        printHorse(horse3, currentYear);
        System.out.println("--- Horse objects ---");
        System.out.println(horse1);
        System.out.println(horse2);
        System.out.println(horse3);
    }

    private static void printHorse(Horse h, int year) {
        System.out.printf("%s is %d years old.%n", h.getName(), h.getAge(year));
    }
}
