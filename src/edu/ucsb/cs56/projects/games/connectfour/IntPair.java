package edu.ucsb.cs56.projects.games.connectfour;

/**
 * Class for the spot points on the board. (used for the undo feature)
 */
public class IntPair {

    private int x;
    private int y;

    /**
     * Constructor for IntPair
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x coordinate of the IntPair
     *
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * get the y coordinate of the IntPair
     *
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * set the x coordinate of the IntPair
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set the y coordinate of the IntPair
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
