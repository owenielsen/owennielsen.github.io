package prog.dev;

/**
 * RaceHorse extends Horse and tracks races won, fastest time, and earnings.
 */
public class RaceHorse extends Horse {
    private int racesWon;
    private double fastestTime; // lower is better; positive-infinity if none yet
    private double earnings;

    public RaceHorse(String name, int yearBorn) {
        super(name, yearBorn);
        this.racesWon = 0;
        this.fastestTime = Double.POSITIVE_INFINITY;
        this.earnings = 0.0;
    }

    /**
     * Record a race result.
     * @param time elapsed time for the race (positive). If <=0, ignored for fastestTime.
     * @param won whether the horse won the race
     * @param prize money won in this race
     */
    public void recordRace(double time, boolean won, double prize) {
        if (time > 0 && time < fastestTime) {
            fastestTime = time;
        }
        if (won) {
            racesWon++;
        }
        if (prize > 0) {
            earnings += prize;
        }
    }

    public int getRacesWon() {
        return racesWon;
    }

    public double getFastestTime() {
        return Double.isInfinite(fastestTime) ? -1 : fastestTime;
    }

    public double getEarnings() {
        return earnings;
    }

    @Override
    public String toString() {
        String ft = Double.isInfinite(fastestTime) ? "n/a" : String.format("%.2f", fastestTime);
        return String.format("RaceHorse{name='%s', yearBorn=%d, racesWon=%d, fastestTime=%s, earnings=$%.2f}",
                getName(), getYearBorn(), racesWon, ft, earnings);
    }
}
