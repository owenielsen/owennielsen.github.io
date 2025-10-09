/**
 * Simple Plant class for the assignment.
 *
 * Attributes:
 * - species (String)
 * - heightCm (double)
 * - hydration (int 0-100)
 * - health (int 0-100)
 *
 * The only way to change the plant's mutable attributes is via the
 * water(int milliliters) method. There are no public setters.
 */
public class Plant {
    private final String species;
    private double heightCm;
    private int hydration; // 0..100
    private int health; // 0..100

    /**
     * Create a new plant.
     * @param species plant species (non-null)
     * @param initialHeightCm initial height in centimeters (>= 0)
     * @param initialHydration initial hydration 0..100
     */
    public Plant(String species, double initialHeightCm, int initialHydration) {
        if (species == null) throw new IllegalArgumentException("species cannot be null");
        if (initialHeightCm < 0) throw new IllegalArgumentException("initialHeightCm must be >= 0");
        if (initialHydration < 0 || initialHydration > 100) throw new IllegalArgumentException("initialHydration must be 0..100");
        this.species = species;
        this.heightCm = initialHeightCm;
        this.hydration = initialHydration;
        // health starts based on hydration: well hydrated plants are healthier
        this.health = Math.max(20, Math.min(100, 50 + (initialHydration - 50) / 1));
    }

    // getters only - no setters so attributes can only be changed by behavior
    public String getSpecies() {
        return species;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public int getHydration() {
        return hydration;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Water the plant. This is the only method that changes the mutable attributes.
     * The simple model:
     * - Each 10 mL increases hydration by 1 point (capped at 100).
     * - Excessive watering (very high hydration) slightly reduces health.
     * - Proper watering increases height a small amount.
     *
     * @param milliliters amount of water given (must be >= 0)
     */
    public void water(int milliliters) {
        if (milliliters < 0) throw new IllegalArgumentException("milliliters must be >= 0");
        int hydrationGain = milliliters / 10; // simple mapping
        if (hydrationGain == 0 && milliliters > 0) hydrationGain = 1; // tiny effect for small amounts

        hydration = Math.min(100, hydration + hydrationGain);

        // growth: small proportional growth based on water
        double growth = hydrationGain * 0.05; // cm per hydration point gained
        heightCm += growth;

        // health: if hydration is in good range (30..80) health improves, if too high or too low it worsens
        if (hydration >= 30 && hydration <= 80) {
            health = Math.min(100, health + 2);
        } else if (hydration > 90) {
            // overwatering penalty
            health = Math.max(0, health - 3);
        } else if (hydration < 20) {
            // underwatered penalty
            health = Math.max(0, health - 2);
        }
    }

    @Override
    public String toString() {
        return String.format("Plant{species='%s', height=%.2fcm, hydration=%d, health=%d}",
                species, heightCm, hydration, health);
    }
}
