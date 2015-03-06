package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Board class uses swing gui to represent the Connect 4 game board
 *
 * @author Vincent Tan
 * @author Girish Kowligi
 * @version Project1, CS56, W14
 *
 */

class Board extends JPanel {
    
    public static int numColumns = 7;
    public static int numRows = 6;
    public static Circle cc;
    private boolean gameOver = false;
    private int drawCounter;
    private static ArrayList<Circle> circleHolder;
    private Circle[][] gameGrid;
    private int turn;
    private boolean singlePlayer = false;
    private int moveCounter = 0;
    private boolean gameIsOver = false;
    private static int player1State;
    private static int player2State;
    private static String redText = "Red";
    private static String yellowText = "Yellow";
    private static String blackText = "Black";
    private static String blueText = "Blue";
    private static String magentaText = "Magenta";
    private static String brownText = "Brown";
    private static String pinkText = "Pink";

    /**
     * Constructor intitializes instance variables and creates the empty game board
     */
    
    public Board() {
        
        circleHolder = new ArrayList<Circle>();
        this.gameGrid = new Circle[numColumns][numRows];
        //Loop through the board and initialize each circle. add it to circleHolder and gameGrid
        
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                cc = new Circle( i * 100 + 55, j * 100 + 55, 90,90);
                circleHolder.add(cc);
                gameGrid[i][j] = cc;
            }
        }
        turn = 1;
    }
    
    
    /**
     * Overridden paint method calls the circle's draw method
     * @param g argument to draw circle
     */
    
    @Override
    public void paint(Graphics g) {
        
	// Draw blue background for contrast
	g.setColor(Color.LIGHT_GRAY);
	g.fillRect(0, 0, this.getWidth(), this.getHeight());
	

        //Loop through gameGrid, drawing each circle that was initialized in Board()
        for (Circle[] circles: gameGrid) {
            for (Circle circle: circles) {
                circle.draw(g);
            }
        }
        //after re-drawing the game board, check if someone has won or if it's a draw
        checkWin(g);
        if (!gameOver)
            checkDraw(g);
    }
    
    /**
     * Displays the win message on the screen when someone has won
     * If It's Red's Turn (turn == 1), and a winner has been detected, Yellow Wins
     * If It's Yellow's Turn (turn == 2) and a winner has been detected, Red Wins
     * @param g to draw the message
     */
    
    public void displayWinner(Graphics g) {
        g.setColor(Color.black);
	if ((player1State == 4) || (player2State ==4))
	    g.setColor(Color.cyan);
        g.setFont(new Font("Times", Font.BOLD, 75));
        String winnerText;
	if (singlePlayer == false){
            if (turn == 1){
		// The switch looks at player 2 because right after
		//     the player wins it switches turns
		switch (player2State) {
		case 1: winnerText = "Red";
		    break;
		case 2: winnerText = "Yellow";
		    break;
		case 4: winnerText = "Black";
		    break;
		case 5: winnerText = "Blue";
		    break;
		case 6: winnerText = "Magenta";
		    break;
		case 7: winnerText = "Brown";
		    break;
		case 8: winnerText = "Pink";
		    break;
		default: winnerText = "P1";
		    break;
		}
                g.drawString(winnerText + " Wins!", 100, 400);
	    }
            else {
		switch (player1State) {
		case 1: winnerText = "Red";
		    break;
		case 2: winnerText = "Yellow";
		    break;
		case 4: winnerText = "Black";
		    break;
		case 5: winnerText = "Blue";
		    break;
		case 6: winnerText = "Magenta";
		    break;
		case 7: winnerText = "Brown";
		    break;
		case 8: winnerText = "Pink";
		    break;
		default: winnerText = "P1";
		    break;
		}
                g.drawString(winnerText + " Wins!", 100, 400);
	    }
        }
        else{
            if (turn == 1)
                g.drawString("YOU LOSE!", 100, 400);
            else
                g.drawString("YOU WIN!", 100, 400);
        }
        this.gameOver = true;
        
    }
    
    /**
     * Determines and displays a draw message if no player wins
     * @param g to draw the message
     */
    
    public void checkDraw(Graphics g) {
        //if 42 successful mouse events
        if (drawCounter == 42) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times", Font.BOLD, 100));
            g.drawString("Draw", 100, 400);
            gameOver = true;
	    this.setGameOver();
        }
    }
    
    /**
     * After every new move, loop through the grid and check
     * for all possible four in a row patterns.
     * @param g necessary to call displayWinner method
     */
    
    public void checkWin(Graphics g) {
        // see if there are 4 disks in a row: horizontal, vertical or diagonal
        
        // horizontal check. loop through the board, row x column,
        // checking the state of each circle.
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                
                int curr = gameGrid[col][row].getState();
                // System.out.println(curr);
                if (curr > 0
                    && curr == gameGrid[col+1][row].getState() //increment the column
                    && curr == gameGrid[col+2][row].getState() //but stay in the same row and
                    && curr == gameGrid[col+3][row].getState() ) //get the state
                {
                    // displayWinner(g, gameGrid[col][row].getState());
                    displayWinner(g);
                    // Change Winning Circles to Blue
                    gameGrid[col][row].setState(3);
                    gameGrid[col+1][row].setState(3);
                    gameGrid[col+2][row].setState(3);
                    gameGrid[col+3][row].setState(3);
                    repaint();
		    this.setGameOver();
                    break;
                }
            }
        }
        
        // vertical check. loop through the whole grid, column x row,
        // checking the state of each circle
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0 //circle is red or yellow
                    && curr == gameGrid[col][row+1].getState() //increment the row
                    && curr == gameGrid[col][row+2].getState() //but stay in the same column
                    && curr == gameGrid[col][row+3].getState() )
                {
                    
                    displayWinner(g);
                    // Change Winning Circles to Blue
                    gameGrid[col][row].setState(3);
                    gameGrid[col][row+1].setState(3);
                    gameGrid[col][row+2].setState(3);
                    gameGrid[col][row+3].setState(3);
                    repaint();
                    this.setGameOver();
		    break;
                }
            }
        }
        
        
        // diagonal check upper left to lower right
        for (int col = 0; col < numColumns - 3; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0
                    && curr == gameGrid[col+1][row+1].getState() //increment the column
                    && curr == gameGrid[col+2][row+2].getState() //and the row by equal
                    && curr == gameGrid[col+3][row+3].getState() ) //amounts and get the state
                {
                    
                    displayWinner(g);
                    // Change Winning Circles to Blue
                    gameGrid[col][row].setState(3);
                    gameGrid[col+1][row+1].setState(3);
                    gameGrid[col+2][row+2].setState(3);
                    gameGrid[col+3][row+3].setState(3);
                    repaint();
		    this.setGameOver();
                    break;
                }
            }
        }
        
        // diagonal upper right to lower left
        for (int col = numColumns - 1; col >= 3; col--) {
            for (int row = 0; row < numRows - 3; row++) {
                int curr = gameGrid[col][row].getState();
                if (curr > 0
                    && curr == gameGrid[col-1][row+1].getState() //move column to the left
                    && curr == gameGrid[col-2][row+2].getState() //and row down, checking
                    && curr == gameGrid[col-3][row+3].getState() ) //each state
                {
                    
                    displayWinner(g);
                    // Change Winning Circles to Blue
                    gameGrid[col][row].setState(3);
                    gameGrid[col-1][row+1].setState(3);
                    gameGrid[col-2][row+2].setState(3);
                    gameGrid[col-3][row+3].setState(3);
                    repaint();
		    this.setGameOver();
                    break;
                }
            }
        }
    }
    

    
    
    //Getter and Setters
    /**
     * Set singlePlayer as true or false
     *@param a set true if the gamemode is singleplayer, false otherwise
     */
    public void setSinglePlayer(boolean a){
        this.singlePlayer = a;
        
    }
    
    /**
     * Get singlePlayer variable
     *@return boolean
     */
    public boolean getSinglePlayer(){
        return this.singlePlayer;
    }
    
    /**
     * Get whose turn it is. (1 or 2)
     * @return int 1 or 2
     */
    public int getTurn(){
        return this.turn;
    }
    
    /**
     * Set whose turn it is.
     *@param t int for whose turn it is (1 or 2)
     */
    public void setTurn(int t){
        if ( (t == 1) || (t == 2))
            this.turn = t;
    }
    
    /**
     * Get drawCounter
     * @return int 
     */
    public int getDrawCounter(){
        return this.drawCounter;
    }
    
    /**
     * Set the drawCounter to parameter s
     * @param s int to set the draw counter to
     */
    public void setDrawCounter(int s){
        this.drawCounter = s;
    }
    
    /**
     * Get if the game is over (true or false)
     * @return boolean
     */
    public boolean getGameOver(){
        return this.gameOver;
    }
    
    /**
     * Get the Circle on the game board at spot (x,y) 
     * @param x x coordinate
     * @param y y coordinate
     * @return Circle
     */
    public Circle getGameGridCircle(int x, int y){
        return gameGrid[x][y];
    }
    
    /**
     * Add 1 to the move counter. If the moveCounter is greater than 41 then it does nothing.
     */
    public void incrementMoveCounter() {
	if (this.moveCounter > 41)
	    return;
	else
	    this.moveCounter++;
	
    }
    
    /**
     * Subtract 1 from the move counter. If the moveCounter is less than 1, then it does nothing.
     */
    public void decrementMoveCounter() {
	if (this.moveCounter < 1)
	    return;
	else
	    this.moveCounter--;
    }
    
    /**
     * Get the moveCounter
     * @return int
     */
    public int getMoveCounter() {
	return this.moveCounter;
    }
    
    /**
     * Set gameIsOver to true
     */
    public void setGameOver() {
	this.gameIsOver = true;
    }

    /**
     * Return the gameIsOver boolean
     * @return boolean
     */
    public boolean checkIfGameOver(){
	return this.gameIsOver;
    }

    /**
     * Set the color state for player 1
     * @param state one of the colors
     */
    
    public void setPlayer1State(int state) {
	player1State = state;
    }
    
    /**
     * Returns the int corresponding to the color selected for player 1
     * @return state int (color) selected for player 1
     */
    public int getPlayer1State() {
	return player1State;
    }

    /**
     * Set the color state for player 2
     * @param state one of the ints for a color
     */
    public void setPlayer2State(int state) {
	player2State = state;
    }

    /**
     * Returns the int corresponding to the color selected for player 2
     * @return state int (color) selected for player 2
     */
    public int getPlayer2State() {
	return player2State;
    }
    

}
