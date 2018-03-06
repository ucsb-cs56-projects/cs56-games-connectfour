package edu.ucsb.cs56.projects.games.connectfour.Logic;

import edu.ucsb.cs56.projects.games.connectfour.GUI.InGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

/**
 * Game object that holds relevant variables to the game's logic
 * Note that this object HAS-A Board object, which itself holds
 * relevant game data specific to the board
 * @author Joel Bagan
 * @author Bryanna Phan
 * @author Brian Lee
 * @author Peter Master
 * @version CS56 F16 UCSB
 */
public class Game implements Serializable{

    private Board board;
    private JFrame frame;
    private JLabel leaderBoardLabel;
    private JScrollPane leaderBoard;
    private int gameMode;
    private int coinTossWinner = -1;
    private int player1Color = 1;
    private int player2Color = 2;
    private int boardColor = 9;
    private int turn;
    private int moveCounter = 0;
    private boolean gameIsOver = false;
    private boolean testingModeEnabled = false;
    private String p1Name = "Player 1";
    private String p2Name = "Player 2";
    private static Stack<IntPair> movesList = new Stack<IntPair>();
    private ArrayList<UserInfo> scores = new ArrayList<UserInfo>();
    

    //This is the list of random AI names and can be adjusted as such.
    private final String[] randomNames = new String[]{
        "Jacob", "Augustine", "Harambe", "Rochester", "Michelle",
        "Kayla", "Deborah", "William", "Howard", "Stewart",
        "Dumbledore", "McKenzie", "Sasha", "Michael", "Alexis"
    };

    //All memory functionality
    /*
    public void reduceScore(){
	currentScore -= 10;
    }
    */

    public void updateLeaderBoard(){
        UserInfo toAdd = new UserInfo(this.getP1Name(), 400 - (10 * moveCounter));
        System.out.println(toAdd.getScore());
        scores.add(toAdd);
        Collections.sort(scores);
        saveLeaderBoard();
    }

    public void saveLeaderBoard(){
        try{
            FileOutputStream fs = new FileOutputStream("SavedScores.ser");
            System.out.println("got this far");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(scores);
            os.close();
            fs.close();
            System.out.println("Saved the scores");
        }
        catch(Exception ex){
            System.out.println("error saving data in saveLeaderBoard()");
        }
    }

    public void loadLeaderBoard(){
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("SavedScores.ser"));
            scores = (ArrayList<UserInfo>) is.readObject();
            is.close();
            System.out.println("loaded the leaderboard from memory");
        }
        catch(Exception ex){
            System.out.println("error reading in data or does not exist yet");
            saveLeaderBoard();
        }
    }

    public String getScoreName(int i){
        try{
            UserInfo tester = scores.get(i);
        }
        catch(Exception ex){
            System.out.println("No names present. populating default");
            for(int x=0; x<10; x++){
                UserInfo info= new UserInfo("empty", 0);
                scores.add(info);
            }
        }
        UserInfo holder = scores.get(i);
        return holder.getName();
    }

    public int getScoreScore(int i){
        try{
            UserInfo tester = scores.get(i);
        }
        catch(Exception ex){
            System.out.println("No names present. populating default");
            for(int x=0; x<10; x++){
                UserInfo info= new UserInfo("empty", 0);
                scores.add(info);
            }
        }
        UserInfo holder = scores.get(i);
        return holder.getScore();
    }
    

    /**
     * Undo the last move that was done. (undo 1 move is multiplayer, 2 moves if singleplayer)
     * updates instance variables as appropriate
     */
    public void undo() {

        if (gameIsOver)
            gameIsOver = false;
        if (moveCounter < 1)
            return;

        if (gameMode == 1) {
            --moveCounter;
            board.setDrawCounter(board.getDrawCounter() - 1);
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
                board.setDrawCounter(board.getDrawCounter() - 1);
                setTurn(1);
                System.out.println("Move Counter Decremented to: " + moveCounter);
                board.getGameGridCircle(tempPair.getX(), tempPair.getY()).setState(0);
            } else {
                IntPair tempPair1 = movesList.pop();
                --moveCounter;
                board.setDrawCounter(board.getDrawCounter() - 1);

                IntPair tempPair2 = movesList.pop();
                --moveCounter;
                board.setDrawCounter(board.getDrawCounter() - 1);

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
        board.setGame(this);
        System.out.println("GameMode is " + getGameMode());

        coinToss();
        turn = getCoinTossWinner();
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

	coinToss();
        turn = getCoinTossWinner();
        if (turn == 2) {
            System.out.println("Player 2 gets to start!");
	    if(getGameMode() != 1) {
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
	}
	else {
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
	coinTossWinner = randomNum.nextInt(3) % 2;//formerly (2 - 1 + 1) + 1
        if (coinTossWinner >= 1) {
            System.out.println("Player 1 gets to start!");
        } else {
	    coinTossWinner = 2;
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

    public void setP2NoName() {
        // Chooses default name for Computers if one was not chosen
        if(this.getP2Name().equals("Player 2") && this.getGameMode() > 1)
            {
                Random random = new Random();
                int randomNameIndex = random.nextInt(randomNames.length);
                System.out.println(randomNameIndex);
                System.out.println(randomNames[randomNameIndex]);
                this.setP2Name(randomNames[randomNameIndex]);
            }
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

    public int getBoardColor()
    {
	return boardColor;
    }

    public void setBoardColor(int boardColor)
    {
	this.boardColor = boardColor;
    }

}
