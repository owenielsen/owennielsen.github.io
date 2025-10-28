package prog.dev;

/**
 * Basic Horse class: name and yearBorn, with ability to rename.
 */
public class Horse {
    private String name;
    private int yearBorn;

    public Horse(String name, int yearBorn) {
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        return String.format("Horse{name='%s', yearBorn=%d}", name, yearBorn);
    }
}
