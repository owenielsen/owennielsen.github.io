import java.util.ArrayList;
import java.util.List;

/**
 * GardenApp: creates several Plant objects and demonstrates their behaviors.
 * This is the main program for the second half of the custom object project.
 */
public class GardenApp {
    public static void main(String[] args) {
        List<Plant> garden = new ArrayList<>();

        // Create at least three Plant objects
        Plant p1 = new Plant("Sunflower", 20.0, 35);
        Plant p2 = new Plant("Aloe", 7.2, 10);
        Plant p3 = new Plant("Fern", 14.0, 80);

        garden.add(p1);
        garden.add(p2);
        garden.add(p3);

        System.out.println("Initial garden state:");
        printGarden(garden);

        // Use behaviors to change attributes. The only way to change hydration/height/health
        // is via the water(...) method on the Plant objects.

        // Water p1 moderately, three times to simulate repeated care
        p1.water(150);
        p1.water(100);
        p1.water(50);

        // Give p2 a small drink and then a larger one
        p2.water(25);
        p2.water(200);

        // Overwater p3 to show health penalty for excessive watering
        p3.water(600);

        System.out.println("\nGarden after watering sequence:");
        printGarden(garden);

        // Use getters to print a short summary for each plant demonstrating accessors
        System.out.println("\nSummary (species: height cm, hydration, health):");
        for (Plant p : garden) {
            System.out.printf("%s: %.2f cm, hydration=%d, health=%d%n",
                    p.getSpecies(), p.getHeightCm(), p.getHydration(), p.getHealth());
        }
    }

    private static void printGarden(List<Plant> garden) {
        for (Plant p : garden) {
            System.out.println(p);
        }
    }
}
