package edu.ucsb.cs56.projects.games.connectfour.AI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Board;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.Logic.IntPair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Advanced AI
 * Notes:
 * (1)Make sure you FULLY understand the way the AI chooses its moves
 * (1.a)To summarize, the AI will;
 * Choose a winning move, else block the opponent's winning move,
 * else, make a triple, else block a triple of the opponent,
 * else, make a random move.
 * <p>
 * (1.b)As the AI looks through the list of moves, it will choose the FIRST
 * move of the specified weight it finds. EX: if there are 2 winning moves,
 * it will choose the first one in the list. So don't make tests that have
 * multiple winning spots and expect it to choose a specific one.
 * <p>
 * (2)By default, Player1Color is 1 (Red), and Player2Color is 2 (Yellow),
 * <p>
 * (3)The AI is Player 2 :P
 */
public class TestAdvancedAI {
    Game g;
    Board b;

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
    public void goForWin() throws Exception {
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
        IntPair spot = new IntPair(1, 2);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

    @Test
    public void BlockVertical() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 1 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 1 ,0 ,0 ,0 ,0 ,0 ,2  },
                        { 1 ,0 ,0 ,0 ,0 ,0 ,2  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(0, 2);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

    @Test
    public void WinOverBlockVert() throws Exception {
        startup();

        int[][] exportedGrid =
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 0, 0, 0, 1},
                        {2, 0, 0, 0, 0, 0, 1},
                        {2, 0, 0, 0, 0, 0, 1}
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(0, 2);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

    @Test
    public void WinOn3Diagonal() throws Exception {
        startup();

        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,2 ,2 ,2  },
                        { 0 ,0 ,0 ,2 ,1 ,1 ,1  },
                        { 0 ,0 ,2 ,1 ,1 ,2 ,1  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(3, 3);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }


    @Test
    public void blockBrokenThreeHoriz() throws Exception {
        startup();
        int[][]exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,2 ,0  },
                        { 1 ,0 ,1 ,1 ,0 ,2 ,0  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(1,5);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

 @Test
    public void blockDiagonal2NE() throws Exception {
        startup();
        int[][]exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,1 ,1 ,0  },
                        { 0 ,0 ,1 ,1 ,2 ,1 ,0  },
                        { 0 ,0 ,1 ,1 ,2 ,2 ,0  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(5,2);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

 @Test
    public void blockDiagonal2NW() throws Exception {
        startup();
        int[][]exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,2 ,1 ,0 ,0 ,0  },
                        { 0 ,1 ,2 ,2 ,1 ,0 ,0  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(2,3);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }



    @Test
    public void blockBrokenThreeNE() throws Exception {
        startup();
        int[][]exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,1 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,2 ,0 ,0 ,0  },
                        { 2 ,1 ,1 ,1 ,2 ,0 ,0  },
                        { 1 ,2 ,2 ,2 ,1 ,0 ,2  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(2,3);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }

    @Test
    public void blockBrokenThreeNW() throws Exception {
        startup();
        int[][]exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,1 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,2 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,1 ,2 ,1 ,0  },
                        { 0 ,0 ,0 ,1 ,2 ,2 ,1  }
                };
        initializeGrid(exportedGrid);

        IntPair spot = new IntPair(4,3);
        IntPair AImove = SinglePlayerAdvanced.AdvancedComputerMove(b);
        assertEquals(spot.getX(), AImove.getX());
        assertEquals(spot.getY(), AImove.getY());
    }
}