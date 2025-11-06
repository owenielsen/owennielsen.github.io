//This is Owen Nielsen btw. Enjoy it or die.

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * "2.4 project" - Demonstrates implementing Comparable on Horse and sorting.
 *
 * Creates an ArrayList of Horse objects, prints them, sorts using Collections.sort,
 * and prints them again so you can see the natural ordering in action.
 */
public class Project2_4 {
    public static void main(String[] args) {
        // Build a list of at least 10 horses with varying birth years and names
        List<Horse> herd = new ArrayList<>();
        herd.add(new Horse("Silver", 2005));
        herd.add(new Horse("Thunder", 2010));
        herd.add(new Horse("Bella", 2012));
        herd.add(new Horse("Apollo", 2000));
        herd.add(new Horse("Zephyr", 2003));
        herd.add(new Horse("Misty", 2015));
        herd.add(new Horse("Duke", 1998));
        herd.add(new Horse("Comet", 2008));
        herd.add(new Horse("Aurora", 2005));
        herd.add(new Horse("Beacon", 2005));
        herd.add(new Horse("Nimble", 1998));

        System.out.println("Before sorting:");
        printHerd(herd);

        // Sort using natural ordering (Horse.compareTo)
        Collections.sort(herd);

        System.out.println();
        System.out.println("After sorting (older horses first, tie-break by name):");
        printHerd(herd);
    }

    /**
     * Helper method to print horses with their computed age for readability.
     */
    private static void printHerd(List<Horse> herd) {
        int currentYear = Year.now().getValue();
        for (Horse h : herd) {
            System.out.printf("%s, age=%d\n", h.toString(), h.getAge(currentYear));
        }
    }
}
