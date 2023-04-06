package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(String recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    private String rounds;
    private String recoveryTime;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String rounds, String recoveryTime) {
        super(n, d, m, y, h, min, s, dist);
        this.rounds = rounds;
        this.recoveryTime = recoveryTime;
    }

    @Override
    public String getEntry() {
        String result = getName() + " ran " + getDistance() + " km " + getRounds() + " RecoveryTime " + getRounds() + " Rounds "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
