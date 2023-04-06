package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location = "";
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String location) {
        super(n, d, m, y, h, min, s, dist);
        this.location = location;
    }

    @Override public String getEntry () {
        String result = getName()+" ran " + getDistance() + " km " + getLocation() + " Location "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
