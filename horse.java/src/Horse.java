import java.time.Year;

/**
 * Simple Horse model used for the assignment.
 * Constructor: oWeN
 */
/**
 * Simple Horse model used for the assignment.
 * Implements Comparable so horses can be ordered (natural ordering).
 * Natural ordering chosen: older horses come before younger horses (smaller birthYear -> earlier).
 */
public class Horse implements Comparable<Horse> {
    private final String name;
    private final int birthYear;

    public Horse(String name, int birthYear) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }

    public int getAge() {
        return getAge(Year.now().getValue());
    }

    @Override
    public String toString() {
        return String.format("Horse{name='%s', birthYear=%d}", name, birthYear);
    }

    /**
     * Compare horses by birth year so that older horses come first.
     * If two horses have the same birth year, compare by name to provide a total ordering.
     *
     * @param other the other Horse to compare to
     * @return negative if this &lt; other (this should come before), 0 if equal, positive if this &gt; other
     */
    @Override
    public int compareTo(Horse other) {
        if (other == null) throw new NullPointerException("Cannot compare to null");
        // older first -> smaller birthYear should come before
        int cmp = Integer.compare(this.birthYear, other.birthYear);
        if (cmp != 0) return cmp;
        // tie-breaker: compare by name
        return this.name.compareTo(other.name);
    }
}
