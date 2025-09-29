public class Horse {
    private String name;
    private int birthYear;

    // horse constructor needs its name and birth year.
    public Horse(String horseName, int year){
        name = horseName; // assigns the name of the horse to the horseName
        birthYear = year; // assigns the year to the birthYear
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // returns age given the current year
    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }

    @Override
    public String toString() {
        return "Horse{name='" + name + "', birthYear=" + birthYear + "}";
    }
}
