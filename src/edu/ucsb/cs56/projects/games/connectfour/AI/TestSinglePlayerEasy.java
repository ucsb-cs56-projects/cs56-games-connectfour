package edu.ucsb.cs56.projects.games.connectfour.AI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Board;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.Logic.IntPair;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the easy difficulty AI
 * tests only ensure that the random moves generated are valid
 */
public class TestSinglePlayerEasy {
    Board b;
    Game g;
    /**
     * Convenience method for initializing the board and game
     * Used in nearly every test to creat a board and game
     * and relate the two
     */
    public void startup() {
        b = new Board();
        g = new Game();
        b.setGame(g);
        g.setBoard(b);
    }

    /**
     * Convenience method for printing out the board to the
     * command line
     * Useful for debugging tests if you think you aren't initializing
     * your board correctly
     */
    public void printBoard() {
        int rowEnd = g.getBoard().numRows;
        int colEnd = g.getBoard().numColumns;

        System.out.println("{");
        for (int j = 0; j < rowEnd; j++) {
            System.out.print("{ ");
            for (int i = 0; i < colEnd; i++) {

                System.out.printf("%1d ", g.getBoard().getGameGrid()[i][j].getState());
                if (!(i == colEnd - 1)) {
                    System.out.print(",");
                }
            }
            System.out.print(" }");
            if (!(j == rowEnd - 1)) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("}");
    }

    /**
     * Method for initializing the Game object's gameGrid variable
     * from a 2D array of ints
     * @param exportedGrid 2D array of ints representing the states of
     *                     the circles at each location. Can easily be
     *                     exported from a game by checking Testing Mode
     *                     box in settings, and pressing Print Board on
     *                     the inGameMenu
     */
    public void initializeGrid(int[][] exportedGrid) {
        int rows = b.numRows;
        int columns = b.numColumns;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                int state = exportedGrid[y][x];
                //seems wrong to do [y][x] but it works :)
                b.setGameGridCircle(x, y, state);

                if (state != 0) {
                    b.setDrawCounter(b.getDrawCounter() + 1);
                }
            }
        }
    }

    @Test
    public void ensureValid() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,2 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,2 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,2 ,1 ,0 ,1 ,0 ,1  }
                };
        initializeGrid(exportedGrid);
        IntPair AImove = SinglePlayerEasy.randomMove(b);
        assertTrue(AImove.getX() < 7 && AImove.getX() >= 0);
        assertTrue(AImove.getY() < 6 && AImove.getY() >= 0);
    }

}