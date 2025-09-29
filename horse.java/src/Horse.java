import java.time.Year;

/**
 * Simple Horse model used for the assignment.
 * Constructor: oWeN
 */
public class Horse {
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
}
