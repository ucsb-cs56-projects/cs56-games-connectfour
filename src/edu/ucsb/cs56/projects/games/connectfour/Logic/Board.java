package edu.ucsb.cs56.projects.games.connectfour.Logic;

import edu.ucsb.cs56.projects.games.connectfour.AI.SinglePlayerAdvanced;
import edu.ucsb.cs56.projects.games.connectfour.AI.SinglePlayerEasy;
import edu.ucsb.cs56.projects.games.connectfour.AI.SinglePlayerNormal;
import edu.ucsb.cs56.projects.games.connectfour.GUI.BoardDisplay;
import edu.ucsb.cs56.projects.games.connectfour.GUI.Circle;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Board object that handles the logic of the game board
 * HAS-A reference to the Game object, and BoardDisplay
 * @author Vincent Tan
 * @author Girish Kowligi
 * @author Joel Bagan
 * @author Bryanna Phan
 * @author Brian Lee
 * @version CS56 F16 UCSB
 */
public class Board {

    private Game game;
    private MouseClass mouseClass = new MouseClass();
    private BoardDisplay display;
    public static int numColumns = 7;
    public static int numRows = 6;
    private int drawCounter = 0;
    public static int winX;
    public static int winY;

    private Circle[][] gameGrid;

    /**
     * Constructor that creates white circles and puts one in every spot in gameGrid
     */
    public Board() {
        Circle cc;
        gameGrid = new Circle[numColumns][numRows];
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                cc = new Circle(i * 100 + 55, j * 100 + 55, 90, 90);
                gameGrid[i][j] = cc;
            }
        }
    }

    /**
     * Method called when restarting the game, exactly the same as constructor
     * but also sets drawCounter to 0
     * We just thought calling the constructor again may mess up the mouseListenter
     * or display, so we just made this which makes all circles white again.
     */
    public void restart() {
        drawCounter = 0;
        Circle cc;
        gameGrid = new Circle[numColumns][numRows];
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                cc = new Circle(i * 100 + 55, j * 100 + 55, 90, 90);
                gameGrid[i][j] = cc;
            }
	}
    }

    /**
     * Determines if a draw has occurred and sets gameIsOver to true if there is a draw\
     * @return true if 42 circles drawn and no win detected, else false
     */
    public boolean checkDraw() {
        if (drawCounter == 42 &&!(checkVertical() && checkMainDiagonal() && checkAntiDiagonal() && checkHorizontal())) {
            game.setGameIsOver(true);
            return true;
        }

        return false;
    }

    /**
     * Checks for a winning string of 4 circles in vertical direction
     * Sets winX and winY to the spot at which the string of circles starts for the draw
     * function to have somewhere to start
     *
     * @return true if winning string found, else false
     */
    public boolean checkVertical() {
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0 //circle is red or yellow
                        && curr == gameGrid[col][row + 1].getState() //increment the row
                        && curr == gameGrid[col][row + 2].getState() //but stay in the same column
                        && curr == gameGrid[col][row + 3].getState()) {
                    winX = col;
                    winY = row;
                    game.setGameIsOver(true);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for a winning string of 4 circles in South-East (Main-diagonal) direction
     * Sets winX and winY to the spot at which the string of circles starts for the draw
     * function to have somewhere to start
     *
     * @return true if winning string found, else false
     */
    public boolean checkMainDiagonal() {
        //upper left to lower right (main diagonal)
        for (int col = 0; col < numColumns - 3; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0
                        && curr == gameGrid[col + 1][row + 1].getState() //increment the column
                        && curr == gameGrid[col + 2][row + 2].getState() //and the row by equal
                        && curr == gameGrid[col + 3][row + 3].getState()) //amounts and get the state
                {
                    winX = col;
                    winY = row;
                    game.setGameIsOver(true);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for a winning string of 4 circles in South-West (Anti-diagonal) direction
     * Sets winX and winY to the spot at which the string of circles starts for the draw
     * function to have somewhere to start
     * @return true if winning string found, else false
     */
    public boolean checkAntiDiagonal(){
        // diagonal upper right to lower left (anti-diagonal)
        for (int col = numColumns - 1; col >= 3; col--) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0
                        && curr == gameGrid[col - 1][row + 1].getState() //move column to the left
                        && curr == gameGrid[col - 2][row + 2].getState() //and row down, checking
                        && curr == gameGrid[col - 3][row + 3].getState()) //each state
                {
                    winX = col;
                    winY = row;
                    game.setGameIsOver(true);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for a winning string of 4 circles in horizontal direction
     * Sets winX and winY to the spot at which the string of circles starts for the draw
     * function to have somewhere to start
     *
     * @return true if winning string found, else false
     */
    public boolean checkHorizontal() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0
                        && curr == gameGrid[col + 1][row].getState() //increment the column
                        && curr == gameGrid[col + 2][row].getState() //but stay in the same row and
                        && curr == gameGrid[col + 3][row].getState()) //get the state
                {
                    winX = col;
                    winY = row;
                    game.setGameIsOver(true);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Class for handling mouse events
     */
    class MouseClass implements MouseListener {
        private int xIndex;
        private int yIndex;

        /**
         * Method for handling a mouse click on the game board
         * @param e MouseEvent object generated from mouseClick
         */
        public void mouseClicked(MouseEvent e) {
            if (game.isGameIsOver())
                return;
            if (game.getGameMode() == 1) {
                handleMPClick(e);
                return;
            } else {
                if (game.getTurn() == 1) {//if human turn
                    handleSPHumanClick(e);
                } else {
                    if (game.getGameMode() == 2) {
                        makeEasyAIMove();
                    } else if (game.getGameMode() == 3) {
                        makeNormalAIMove();
                    } else if (game.getGameMode() == 4) {
                        makeAdvancedAIMove();
                    }
                }
            }
            display.updateTurnPanel();
            //unsure of why this method MUST be called both in this function, and inside the paint()method
            //of BoardDisplay, doesn't work otherwise
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        /**
         * Method for making an AI move on advanced difficulty
         */
        private void makeAdvancedAIMove() {
            try {
                Thread.sleep(500);
                IntPair advancedMoveSpot = SinglePlayerAdvanced.AdvancedComputerMove(getSelf());
                xIndex = advancedMoveSpot.getX();
                yIndex = advancedMoveSpot.getY();
                gameGrid[xIndex][yIndex].setState(game.getPlayer2Color());
                display.repaint();
                game.incrementMoveCounter();
                game.getMovesList().push(advancedMoveSpot);
                game.setTurn(1);
                ++drawCounter;
                System.out.println("Move Counter: " + game.getMoveCounter());
            } catch (InterruptedException ex1) {
                System.out.println("Broken Thread");
            }
        }

        /**
         * Method for making an AI move on normal difficulty
         */
        private void makeNormalAIMove() {
            try {
                Thread.sleep(500);
                IntPair normalMoveSpot = SinglePlayerNormal.normalComputerMove(getSelf());
                xIndex = normalMoveSpot.getX();
                yIndex = normalMoveSpot.getY();
                gameGrid[xIndex][yIndex].setState(game.getPlayer2Color());
                display.repaint();

                game.incrementMoveCounter();
                game.getMovesList().push(normalMoveSpot);
                game.setTurn(1);
                ++drawCounter;
                System.out.println("Move Counter: " + game.getMoveCounter());
            } catch (InterruptedException ex1) {
                System.out.println("Broken Thread");
            }
        }

        /**
         * Method for making an AI move on easy difficulty
         */
        private void makeEasyAIMove() {
            try {
                Thread.sleep(500);
                //Generate a Random Move
                IntPair easyMoveSpot = SinglePlayerEasy.randomMove(getSelf());
                xIndex = easyMoveSpot.getX();
                yIndex = easyMoveSpot.getY();
                gameGrid[xIndex][yIndex].setState(game.getPlayer2Color());
                display.repaint();
                game.incrementMoveCounter();
                game.getMovesList().push(easyMoveSpot);
                game.setTurn(1);
                ++drawCounter;
                System.out.println("Move Counter: " + game.getMoveCounter());
            } catch (InterruptedException ex1) {
                System.out.println("Broken Thread");
            }
        }

        /**
         * Method for handling a human mouse click in singleplayer
         * @param e MouseEvent object from mouse click
         */
        private void handleSPHumanClick(MouseEvent e) {
            xIndex = e.getX() / 100;
            yIndex = 0;
            //find lowest empty circle
            while (gameGrid[xIndex][yIndex + 1].getState() == 0) {
                yIndex++;
                if (yIndex == Board.numRows - 1) {
                    break;
                }
            }

            //if the top circle is already filled, do nothing and return
            if (yIndex == 0 && gameGrid[xIndex][yIndex].getState() != 0) {
                return;
            }

            gameGrid[xIndex][yIndex].setState(game.getPlayer1Color());
            game.incrementMoveCounter();
            System.out.println("Move Counter: " + game.getMoveCounter());
            IntPair spotOnBoard = new IntPair(xIndex, yIndex);
            game.getMovesList().push(spotOnBoard);

            //change turns
            game.setTurn(2);

            //repaint after every mouseClick

            display.repaint();

            ++drawCounter;

            //Make a automatic mouse click to start the Computer Move
            try {
                // Thread.sleep(1000);
                Robot r = new Robot();
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);

            } catch (AWTException ex) {
                System.out.println("didn't work");
            }
        }

        /**
         * Method for handling a click when the gameMode is multiplayer
         * @param e MouseEvent object about the mouseClick
         */
        private void handleMPClick(MouseEvent e) {
            xIndex = e.getX() / 100;
            yIndex = 0;

            while ((gameGrid[xIndex][yIndex + 1]).getState() == 0) {
                yIndex++;
                if (yIndex == Board.numRows - 1) {
                    break;
                }
            }

            //if the top circle is already filled, do nothing and return
            if (yIndex == 0 && gameGrid[xIndex][yIndex].getState() != 0) {
                return;
            }

            //set the selected circle's state to current player's color
            if (game.getTurn() == 1) {
                gameGrid[xIndex][yIndex].setState(game.getPlayer1Color());
            } else if (game.getTurn() == 2) {
                gameGrid[xIndex][yIndex].setState(game.getPlayer2Color());
            }
            display.repaint();
            game.incrementMoveCounter();
            System.out.println("Move Counter: " + game.getMoveCounter());
            IntPair spotOnBoard = new IntPair(xIndex, yIndex);
            game.getMovesList().push(spotOnBoard);

            //change turns
            if (game.getTurn() == 1) {
                game.setTurn(2);
                //inGameMenuP.setCurrentTurn(player2ColorState);
            } else {
                game.setTurn(1);
                //inGameMenuP.setCurrentTurn(player1ColorState);
            }
            ++drawCounter;
        }



    }

    //Getters and Setters
    public MouseClass getMouseClass() {
        return mouseClass;
    }

    public void setMouseClass(MouseClass mouseClass) {
        this.mouseClass = mouseClass;
    }

    public Game getGame() {
        return game;
    }

    public BoardDisplay getDisplay() {
        return display;
    }

    public void setDisplay(BoardDisplay display) {
        this.display = display;
    }

    public int getDrawCounter() {
        return drawCounter;
    }

    public void setDrawCounter(int drawCounter) {
        this.drawCounter = drawCounter;
    }

    public Circle[][] getGameGrid() {
        return gameGrid;
    }

    public Circle getGameGridCircle(int xIndex, int yIndex) {
        return gameGrid[xIndex][yIndex];
    }

    public void setGameGridCircle(int xIndex, int yIndex, int state) {
        gameGrid[xIndex][yIndex].setState(state);
    }

    public void setGameGrid(Circle[][] gameGrid) {
        this.gameGrid = gameGrid;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Board getSelf() {
        return this;
    }
}
