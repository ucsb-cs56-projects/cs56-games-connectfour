package edu.ucsb.cs56.projects.games.connectfour.Logic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test class for the Board logic
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class TestBoard {
    Game g;
    Board b;


    /**
     * Convenience method for initializing the board and game
     * Used in nearly every test to creat a board and game
     * and relate the two
     */
    public void startup(){
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
     *                     the InGameMenu
     */
    public void initializeGrid(int[][] exportedGrid){
        int rows = b.numRows;
        int columns = b.numColumns;
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){
                int state = exportedGrid[y][x];
                //seems wrong to do [y][x] but it works :)
                b.setGameGridCircle(x, y, state);

                if(state !=  0){
                    b.setDrawCounter(b.getDrawCounter() + 1);
                }
            }
        }
    }

    @Test
    public void checkDraw() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        { 2 ,2 ,1 ,2 ,1 ,2 ,1  },
                        { 1 ,1 ,2 ,1 ,2 ,1 ,1  },
                        { 2 ,1 ,2 ,1 ,2 ,1 ,2  },
                        { 2 ,1 ,2 ,1 ,2 ,1 ,2  },
                        { 1 ,2 ,1 ,2 ,1 ,2 ,1  },
                        { 2 ,1 ,2 ,1 ,2 ,1 ,2  }
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkDraw());

    }

    @Test
    public void checkMainDiag() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0},
                        {2, 1, 0, 0, 0, 0, 0},
                        {1, 2, 1, 0, 0, 0, 0},
                        {1, 2, 2, 1, 2, 0, 0}
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkMainDiagonal());

    }

    @Test
    public void checkWinVert() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,1 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,1 ,2 ,0 ,0 ,0  },
                        { 0 ,0 ,1 ,2 ,0 ,0 ,0  },
                        { 0 ,0 ,1 ,2 ,0 ,0 ,0  }
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkVertical());
    }

    @Test
    public void checkWinHoriz() throws Exception {
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 2 ,2 ,2 ,0 ,0 ,0 ,0  },
                        { 1 ,1 ,1 ,1 ,0 ,0 ,0  }
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkHorizontal());
    }

    @Test
    public void checkWinAntiDiag() throws Exception{
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,1 ,0 ,0  },
                        { 0 ,0 ,0 ,1 ,2 ,0 ,0  },
                        { 0 ,0 ,1 ,2 ,1 ,1 ,0  },
                        { 0 ,1 ,2 ,2 ,1 ,2 ,2  }
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkAntiDiagonal());
    }

    @Test
    public void checWinMainDiag() throws Exception{
        startup();
        int[][] exportedGrid =
                {
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,0 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,1 ,0 ,0 ,0  },
                        { 0 ,0 ,0 ,2 ,1 ,0 ,0  },
                        { 0 ,0 ,0 ,2 ,2 ,1 ,0  },
                        { 0 ,0 ,1 ,1 ,2 ,2 ,1  }
                };
        initializeGrid(exportedGrid);
        assertTrue(b.checkMainDiagonal());
    }

}