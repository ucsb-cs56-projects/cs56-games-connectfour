package edu.ucsb.cs56.projects.games.connectfour.AI;

import edu.ucsb.cs56.projects.games.connectfour.GUI.Circle;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Board;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.Logic.IntPair;

import java.util.Random;

/**
 * Single player easy difficulty class
 * This level of AI only makes random moves
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SinglePlayerEasy {

    /**
     * Method that generates a random move on the board and returns an IntPair of the spot chosen
     *
     * @param b Board that method gets information from to generate move
     * @return IntPair the IntPair of the spot randomly chosen.
     */
    public static IntPair randomMove(Board b) {
        Random rand = new Random();
        int xIndex = rand.nextInt(7);
        int yIndex = 0;
        Game game = b.getGame();
        Circle[][] gameGrid = b.getGameGrid();
        if (!game.isGameIsOver()) {    //make sure game is not already over
            // make sure random column is not already full
            while (gameGrid[xIndex][yIndex].getState() != 0) {
                xIndex = (xIndex + 1) % 7;
            }

            //find the lowest empty slot in the chosen column
            //Place a circle there
            while (gameGrid[xIndex][yIndex+1].getState() == 0) {
                yIndex++;
                if (yIndex == Board.numRows - 1) {
                    break;
                }
            }
        }
        AIDebuggingOutput.println("AI move is " + xIndex + "," + yIndex);
        return new IntPair(xIndex, yIndex);
    }
}
