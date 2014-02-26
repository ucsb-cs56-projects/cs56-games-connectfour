package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
   Board class uses swing gui to represent the Connect 4 game board

   @author Vincent Tan
   @author Girish Kowligi
   @version Project1, CS56, W14

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
    
    /**
     Constructor intitializes instance variables and creates the empty game board
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
       Overridden paint method calls the circle's draw method
       @param g argument to draw circle
    */

    @Override
    public void paint(Graphics g) {

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
       Displays the win message on the screen when someone has won
       If It's Red's Turn (turn == 1), and a winner has been detected, Yellow Wins
       If It's Yellow's Turn (turn == 2) and a winner has been detected, Red Wins
       @param g to draw the message
    */

    public void displayWinner(Graphics g, int state) {
	g.setColor(Color.BLACK);
	g.setFont(new Font("Times", Font.BOLD, 100));
	
	if (state == 1)
	    g.drawString("Red Wins!", 0, 400);
	else
	    g.drawString("Yellow Wins!", 100, 400);
	
	this.gameOver = true;
        
    }

    /** 
       Determines and displays a draw message if no player wins
       @param g to draw the message
    */

    public void checkDraw(Graphics g) {
	//if 42 successful mouse events
	if (drawCounter == 42) {
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Times", Font.BOLD, 100));
	    g.drawString("Draw", 100, 400);
	    gameOver = true;
	}
    }

    /**
     *After every new move, loop through the grid and check
     *for all possible four in a row patterns.
       @param g necessary to call displayWinner method
    */

    public void checkWin(Graphics g) {
	// see if there are 4 disks in a row: horigitzontal, vertical or diagonal
	
	// horizontal check. loop through the board, row x column,
	// checking the state of each circle.
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numColumns - 3; col++) {
		
		int curr = gameGrid[col][row].getState();
		//  System.out.println(curr);
		if (curr > 0
		    && curr == gameGrid[col+1][row].getState() //increment the column
		    && curr == gameGrid[col+2][row].getState() //but stay in the same row and
		    && curr == gameGrid[col+3][row].getState() ) //get the state
		    {
			//  displayWinner(g, gameGrid[col][row].getState());
			displayWinner(g, curr);
			// Change Winning Circles to Blue
			gameGrid[col][row].setState(3);
			gameGrid[col+1][row].setState(3);
			gameGrid[col+2][row].setState(3);
			gameGrid[col+3][row].setState(3);
			repaint();
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
                
			displayWinner(g, curr);
			// Change Winning Circles to Blue
			gameGrid[col][row].setState(3);
			gameGrid[col][row+1].setState(3);
			gameGrid[col][row+2].setState(3);
			gameGrid[col][row+3].setState(3);
			repaint();
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
			   
			displayWinner(g, curr);
			// Change Winning Circles to Blue
			gameGrid[col][row].setState(3);
			gameGrid[col+1][row+1].setState(3);
			gameGrid[col+2][row+2].setState(3);
			gameGrid[col+3][row+3].setState(3);
			repaint();
			break;
		    }
	    }
	}

	// diagonal upper right to lower left
	for (int col = numColumns - 1; col >= 3; col--) {
	    for (int row = 0; row < numRows - 3; row++) {
		int curr = gameGrid[col][row].getState();
		if (curr > 0
		    && curr == gameGrid[col-1][row+1].getState()  //move column to the left
		    && curr == gameGrid[col-2][row+2].getState() //and row down, checking
		    && curr == gameGrid[col-3][row+3].getState() ) //each state
		    {
			
			displayWinner(g, curr);
			// Change Winning Circles to Blue
			gameGrid[col][row].setState(3);
			gameGrid[col-1][row+1].setState(3);
			gameGrid[col-2][row+2].setState(3);
			gameGrid[col-3][row+3].setState(3);
			repaint();
			break;
		    }
	    }
	}
    }
  
    public void simpleComputerMove(){
        
        if (!gameOver){
	    Random rand = new Random();
	    int xIndex = rand.nextInt(7);
	    int yIndex = 0;

	    while (gameGrid[xIndex][yIndex].getState() != 0) {
		xIndex = (xIndex + 1)%7;
	    }
            
	    while(gameGrid[xIndex][yIndex+1].getState() == 0){
		yIndex++;
		if (yIndex == numRows - 1) {
		    break;
		}
	    }
            
	    gameGrid[xIndex][yIndex].setState(turn);
	    turn = 1;
	    repaint();
	    drawCounter++;
        }
    }
    
    public int getTurn(){
        return this.turn;
    }
    
    public void setTurn(int t){
        if ( (t == 1) || (t == 2))
            this.turn = t;
    }
    
    public int getDrawCounter(){
        return this.drawCounter;
    }
    
    public void setDrawCounter(int s){
        this.drawCounter = s;
    }
    
    public boolean getGameOver(){
        return this.gameOver;
    }
    
    public Circle getGameGridCircle(int x, int y){
        return gameGrid[x][y];
    }
    

}
