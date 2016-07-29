package edu.ucsb.cs56.projects.games.connectfour.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.Stack;

/**
 * Game object that holds relevant variables to the game's logic
 * Note that this object HAS-A Board object, which itself holds
 * relevant game data specific to the board
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class Game {

    private Board board;
    private JFrame frame;
    private int gameMode;
    private int coinTossWinner = -1;
    private int player1Color = 1;
    private int player2Color = 2;
    private int turn;
    private int moveCounter = 0;
    private boolean gameIsOver = false;
    private boolean testingModeEnabled = false;
    private String p1Name = "Player 1";
    private String p2Name = "Player 2";
    private static Stack<IntPair> movesList = new Stack<IntPair>();

    /**
     * Undo the last move that was done. (undo 1 move is multiplayer, 2 moves if singleplayer)
     * updates instance variables as appropriate
     */
    public void undo() {
        if (gameIsOver)
            return;
        if (moveCounter < 1)
            return;

        if (gameMode == 1) {
            --moveCounter;
            System.out.println("Move Counter Decremented to: " + moveCounter);
            IntPair tempPair = movesList.pop();
            int xSpot = tempPair.getX();
            int ySpot = tempPair.getY();
            board.getGameGridCircle(xSpot, ySpot).setState(0);
            board.getDisplay().repaint();
            if (turn == 1) {
                setTurn(2);
            } else {
                setTurn(1);
            }
        } else if ((gameMode == 2) || (gameMode == 3) || (gameMode == 4)) {
            if (moveCounter < 1)
                return;

            // The only time there is only one move is when there is the bug
            // from X11 forwarding.
            // As a result the game can get confused and accidentally switch turns
            // if the turn state is not set.
            // (It is currently set to always return to the user's turn)
            if (moveCounter % 2 == 1 && coinTossWinner == 1) {
                IntPair tempPair = movesList.pop();
                --moveCounter;
                setTurn(1);
                System.out.println("Move Counter Decremented to: " + moveCounter);
                board.getGameGridCircle(tempPair.getX(), tempPair.getY()).setState(0);
            } else {
                IntPair tempPair1 = movesList.pop();
                --moveCounter;
                IntPair tempPair2 = movesList.pop();
                --moveCounter;

                System.out.println("Move Counter Decremented to: " + moveCounter);
                board.getGameGridCircle(tempPair1.getX(), tempPair1.getY()).setState(0);
                board.getGameGridCircle(tempPair2.getX(), tempPair2.getY()).setState(0);
            }
            board.getDisplay().repaint();
        }
    }

    /**
     * Method that handles the logic of starting a new game
     * Called from player2ColorSelectMenu
     */
    public void launchGame() {
        gameIsOver = false;
        moveCounter = 0;
        movesList.clear();
        Board board = new Board();
        this.board = board;
//        board.setFrame(frame);
        board.setGame(this);
        System.out.println("GameMode is " + getGameMode());

        coinToss();
        turn = coinTossWinner;
        if (gameMode!= 1 && turn == 2) {
            try {
                Robot r = new Robot();
                Point p = frame.getLocationOnScreen();
                Point current = MouseInfo.getPointerInfo().getLocation();
                r.mouseMove((int) p.getX() + 50, (int) p.getY() + 50);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.mouseMove((int) current.getX(), (int) current.getY());
            } catch (AWTException ex) {
                System.out.println("didn't work");
            }
        }
        board.setDrawCounter(0);
    }

    /**
     * Method that handles the logic of restarting the game
     * called when restart button is pressed in the in game menu
     */
    public void restartGame() {
        gameIsOver = false;

        System.out.println("Restarting...");

        System.out.println("GameMode is " + getGameMode());

        turn = coinTossWinner;
        if (turn == 2) {
            System.out.println("Player 2 gets to start!");
            try {
                // Thread.sleep(1000);
                Robot r = new Robot();
                Point p = frame.getLocationOnScreen();
                Point current = MouseInfo.getPointerInfo().getLocation();
                r.mouseMove((int) p.getX() + 50, (int) p.getY() + 50);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.mouseMove((int) current.getX(), (int) current.getY());
            } catch (AWTException ex) {
                System.out.println("didn't work");
            }
        } else {
            System.out.println("Player 1 gets to start!");

        }
        board.setGame(this);
        moveCounter = 0;
        movesList.clear();
        board.setDrawCounter(0);
    }

    /**
     * Method that simulates a coin flip, generating a 1 or 2 at random
     * stores result in coinTossWinner, which is used to determine first
     * turn when game is launched and restarted
     */
    public void coinToss() {
        Random randomNum = new Random();
        coinTossWinner = randomNum.nextInt(2 - 1 + 1) + 1;
        if (coinTossWinner == 1) {
            System.out.println("Player 1 gets to start!");
        } else {
            System.out.println("Player 2 gets to start!");
        }
    }

    //Getters and Setters
    public static Stack<IntPair> getMovesList() {
        return movesList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static void setMovesList(Stack<IntPair> movesList) {
        Game.movesList = movesList;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void incrementMoveCounter() {
        ++moveCounter;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public int getPlayer1Color() {
        return player1Color;
    }

    public void setPlayer1Color(int player1Color) {
        this.player1Color = player1Color;
    }

    public int getPlayer2Color() {
        return player2Color;
    }

    public void setPlayer2Color(int player2Color) {
        this.player2Color = player2Color;
    }

    public String getP1Name() {
        return p1Name;
    }

    public void setP1Name(String p1Name) {
        this.p1Name = p1Name;
    }

    public String getP2Name() {
        return p2Name;
    }

    public void setP2Name(String p2Name) {
        this.p2Name = p2Name;
    }

    public int getCoinTossWinner() {
        return coinTossWinner;
    }

    public void setCoinTossWinner(int coinTossWinner) {
        this.coinTossWinner = coinTossWinner;
    }

    public boolean isTestingModeEnabled() {
        return testingModeEnabled;
    }

    public void setTestingModeEnabled(boolean testingModeEnabled) {
        this.testingModeEnabled = testingModeEnabled;
    }

}
