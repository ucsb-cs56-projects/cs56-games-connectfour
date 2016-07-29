package edu.ucsb.cs56.projects.games.connectfour;

class Tuple {
    private IntPair location;
    private int weight;

    public Tuple(IntPair location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLocation(IntPair location) {
        this.location = location;
    }

    public int getWeight() {
        return this.weight;
    }

    public IntPair getLocation() {
        return this.location;
    }
}
