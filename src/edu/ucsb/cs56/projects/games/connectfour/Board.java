package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
   Board class uses swing gui to represent the Connect 4 game board

   @author Girish Kowligi
   @author Vincent Tan
   @version Project1, CS56, W14

*/

public class Board extends JPanel {

    public static int numColumns = 7;
    public static int numRows = 6;

    public static int frame_width = 720;
    public static int frame_height = 650;

    public static Circle cc;

    private boolean gameOver;
    private int drawCounter;

    private static ArrayList<Circle> circleHolder;
    private Circle[][] gameGrid;
    private int turn;

    public static JFrame frame;

    public static void main (String [] args){
        
        frame = new JFrame();;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frame_width,frame_height);
        
        frame.add(new Board());
        frame.repaint();
        frame.setVisible(true);
    }
    
    
    //public void go(){}
    
    
    

    /**
     Constructor intitializes instance variables and creates the empty game board
    */

    public Board() {

	circleHolder = new ArrayList<Circle>();   
	this.gameGrid = new Circle[numColumns][numRows];   
	frame.addMouseListener(new MouseClass());   //register the frame with the mouse

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

    public void displayWinner(Graphics g) {
	g.setColor(Color.BLACK);
	g.setFont(new Font("Times", Font.BOLD, 100));
	
	if (turn == 1){
	    g.drawString("Yellow Wins!", 0, 400);
	}
	else {
	    g.drawString("Red Wins!", 100, 400);
	}

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
	// see if there are 4 disks in a row: horizontal, vertical or diagonal
	
	// horizontal check. loop through the board, row x column,
	// checking the state of each circle.
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numColumns - 3; col++) {
		
		int curr = gameGrid[col][row].getState();
		if (curr > 0
		    && curr == gameGrid[col+1][row].getState() //increment the column
		    && curr == gameGrid[col+2][row].getState() //but stay in the same row and
		    && curr == gameGrid[col+3][row].getState() ) //get the state
		    {
			//  displayWinner(g, gameGrid[col][row].getState());
			displayWinner(g);
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
                
			displayWinner(g);
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
			   
			displayWinner(g);
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
			
			displayWinner(g);
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
   
    /** 
	Inside class MouseClass implements the MouseListener interface.
    */

    class MouseClass implements MouseListener {
	private int xIndex;
	private int yIndex;

	/** 
	            mouseClicked function handles the event appropriately when
		        the user clicks on the board.
			        @param e represents the mouseEvent.
	*/

	public void mouseClicked(MouseEvent e) {
	    //dont respond to mouse events if the game is over
	    if (gameOver)
		return;

	    xIndex = e.getX() / 100;
	    yIndex = 0;
	            
	    //move down the selected column until you reach a circle that is red or yellow
	    //if you reach the bottom-most circle, break
	    while(gameGrid[xIndex][yIndex + 1].getState() == 0)
		{
		    yIndex++;
		    if (yIndex == numRows - 1) {
			break;
		    }
		}

	    //if the top circle is already filled, do nothing and return
	    if (yIndex == 0 && gameGrid[xIndex][yIndex].getState() != 0) {
		return;
	    }

	    //set the selected circle's state to current turn value (1 or 2)
	    gameGrid[xIndex][yIndex].setState(turn);

	    //change turns
	    if (turn == 1) {
		turn = 2;
	    }
	    else {
		turn = 1; 
	    }

	    //repaint after every mouseClick
	    repaint();

	    drawCounter++;
	                
	}

	/**
	         mouseEntered is a function in the MouseListener interface
		          @param e represents the mouseEvent
	*/
	
	public void mouseEntered(MouseEvent e) {
	    // TODO Auto-generated method stub
	        
	}
    
	/**                                                                                                                                                             
           mouseExited is a function in the MouseListener interface                                                                                                    
           @param e represents the mouseEvent                                                                                                                           
	*/

	public void mouseExited(MouseEvent e) {
	    // TODO Auto-generated method stub
	            
	}

	/**                                                                                                                                                             
           mousePressed is a function in the MouseListener interface                                                                                                    
           @param e represents the mouseEvent                                                                                                                           
	        */

	public void mousePressed(MouseEvent e) {
	    //TODO Auto-generated method stub
	}

	/**                                                                                                                                                             
           mouseReleased is a function in the MouseListener interface                                                                                                   
           @param e represents the mouseEvent                                                                                                                           
	*/

	public void mouseReleased(MouseEvent e) {
	    // TODO Auto-generated method stub
	        
	}
	
    }
}

