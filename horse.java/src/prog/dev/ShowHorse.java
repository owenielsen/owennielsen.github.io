package prog.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * ShowHorse extends Horse and tracks show titles and earnings from shows.
 */
public class ShowHorse extends Horse {
    private final List<String> titles;
    private double earnings;

    public ShowHorse(String name, int yearBorn) {
        super(name, yearBorn);
        this.titles = new ArrayList<>();
        this.earnings = 0.0;
    }

    public void addTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            titles.add(title.trim());
        }
    }

    public void addEarnings(double amount) {
        if (amount > 0) {
            earnings += amount;
        }
    }

    public List<String> getTitles() {
        return new ArrayList<>(titles);
    }

    public double getEarnings() {
        return earnings;
    }

    @Override
    public String toString() {
        return String.format("ShowHorse{name='%s', yearBorn=%d, titles=%s, earnings=$%.2f}",
                getName(), getYearBorn(), titles.toString(), earnings);
    }
}
