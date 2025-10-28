package prog.dev;

/**
 * Wrapper main class to demonstrate Horse, RaceHorse, and ShowHorse.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Creating base Horse ---");
        Horse generic = new Horse("Buddy", 2010);
        System.out.println(generic);
        generic.rename("Buddy Jr.");
        System.out.println("After rename: " + generic);

        System.out.println();
        System.out.println("--- Creating RaceHorse ---");
        RaceHorse racer = new RaceHorse("Lightning", 2015);
        System.out.println(racer);
        System.out.println("Recording races...");
        racer.recordRace(12.34, true, 5000.0);
        racer.recordRace(11.98, false, 0.0);
        racer.recordRace(11.50, true, 7500.0);
        System.out.println("After races: " + racer);

        System.out.println();
        System.out.println("--- Creating ShowHorse ---");
        ShowHorse show = new ShowHorse("Grace", 2012);
        System.out.println(show);
        System.out.println("Adding titles and earnings...");
        show.addTitle("Best in Show 2018");
        show.addTitle("Grand Champion 2019");
        show.addEarnings(1200.0);
        show.addEarnings(2500.0);
        System.out.println("After shows: " + show);

        System.out.println();
        System.out.println("--- Mixed array demonstration ---");
        Horse[] herd = new Horse[] { generic, racer, show };
        for (Horse h : herd) {
            System.out.println(h);
        }
    }
}
