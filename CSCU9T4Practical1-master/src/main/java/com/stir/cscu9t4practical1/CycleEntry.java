package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{
    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String terrain;

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        tempo = tempo;
    }

    public String tempo = "";
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrian, String tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.terrain = terrian;
        this.tempo = tempo;
    }

    @Override public String getEntry () {
        String result = getName()+" Cycled " + getDistance() + " km " + getTerrain() + " terrain " + getTempo() + " Tempo "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //getEntry
}
