package edu.ucsb.cs56.projects.games.connectfour.Logic;

/**
 * Class for a tuple that holds an IntPair and an int to represent
 * a location on the gameGrid, and a weight for the 'goodness' of a move
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class Tuple {
    private IntPair location;
    private int weight;

    /**
     * Constructor
     * @param location IntPair of the spot on the gameGrid
     * @param weight int of the 'goodness' of the move
     */
    public Tuple(IntPair location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    //getters and setters
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
