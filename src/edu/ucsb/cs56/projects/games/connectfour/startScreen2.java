package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 startScreen2 class uses swing gui to represent the Connect 4 start Menu
 @author Vincent Tan
 @author Girish Kowligi
 @version Project1, CS56, W14
 */


public class startScreen2 extends JFrame {
    
    
    
    public static int frame_width = 880;
    public static int frame_height = 650;
    public static int menu_width = 240;
    public static int menu_height = 320;
    public static Board b;
    private static StartScreenButtonsPanel ss;
    private int gameMode = 1;
    private static singlePlayerMenuPanel SPMenu;
    private static rulesPanel RulesMenu;
    private static inGameMenuPanel inGameMenuP;
    private static Stack<IntPair> movesList = new Stack<IntPair>();
    
    
    // Launch game
    public static void main (String [] args){
        JFrame frame = new startScreen2();
        
    }
    
    /**
     Constructor intitializes JFrame For all panel
     */
    
    // initial screen when program is executed
    public startScreen2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(menu_width,menu_height);
        this.setResizable(false);
        ss = new StartScreenButtonsPanel(this);
        this.add(ss);
        this.addMouseListener(new MouseClass());
        this.setVisible(true);
        
        
    }
    
    // When single Player Button is pressed
    // Allow player to choose level of difficulty
    public void loadSinglePlayerMenu(){
        this.setSize(menu_width,menu_height);
        this.remove(ss);
        this.repaint();
        SPMenu = new singlePlayerMenuPanel(this);
        this.add(SPMenu);
        this.revalidate();
        
        
    }

    // Loads the rules page when the rules button
    // is pressed
    public void loadRulesPage() {
	this.setSize(menu_width,menu_height);
        this.remove(ss);
        this.repaint();
        RulesMenu = new rulesPanel(this);
        this.add(RulesMenu);
        this.revalidate();
    }

    /**
     Navigate Back to the main Menu
     */
    public void BackToStartScreen(){
        if (b != null)
            remove(b);
        if (inGameMenuP != null)
            remove(inGameMenuP);
        
        this.setSize(menu_width,menu_height);
        if (SPMenu != null)
            this.remove(SPMenu);
	if (RulesMenu != null)
	    this.remove(RulesMenu);

        this.add(ss);
        repaint();
        this.revalidate();
        
    }
    
    // remove the board if one already exists
    // and make a new one
    public void launchGame(){
        // Make sure Panel already Exist.
        // remove if it does.
        if (b != null)
            this.remove(b);
        if (inGameMenuP != null)
            this.remove(inGameMenuP);
        this.repaint();
        
        // set the Game size ready for The board
        this.setSize(frame_width,frame_height);
        // Remove SinglePlayer Menu if it exist
        if (SPMenu != null)
            this.remove(SPMenu);
        // remove startScreen if it exist
        if (ss!= null)
            this.remove(ss);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        // initiate a new board and a in-Game Menu
        inGameMenuP = new inGameMenuPanel(this);
        b = new Board();
        
        // add it to frame and refresh
        this.add(b);
        this.add(inGameMenuP);
        this.revalidate();
        this.repaint();
        
        
    }
    
    public void undo() {
	if (b.checkIfGameOver() == true)
	    return;
	if (b.getMoveCounter() < 1)
	    return;
	
	// gameMode is multiplayer
	if (gameMode == 1) {
	    // Decrement moveCounter
	    b.decrementMoveCounter();
	    System.out.println("Move Counter Decremented to: " + b.getMoveCounter());
	    
	    // pop from movesList
	    IntPair tempPair= movesList.pop();
	    
	    // switch turns back to original person
	    if (b.getTurn() == 1) {
		b.setTurn(2);
	    }
	    else {
		b.setTurn(1);
	    }

	    int xSpot = tempPair.getX();
	    int ySpot = tempPair.getY();

	    // set spot as available
	    b.getGameGridCircle(xSpot, ySpot).setState(0);
	    
	    // redraw circle as all white
	    b.repaint();
	    return;

	}

	// gameMode is singleplayer
	else if ((gameMode == 2) || (gameMode == 3)) {
	    System.out.println("Undo has not been written yet");
	}
    }
    

    class MouseClass implements MouseListener{
        private int xIndex;
        private int yIndex;
        
        public void mouseClicked(MouseEvent e){
            if (b.getGameOver())
                return;
            
            System.out.println("GameMode is " + gameMode);
            if (gameMode == 1){// multiplayer
                b.setSinglePlayer(false);
                xIndex = e.getX()/100;
                yIndex = 0;
                
                
                while(b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)
                {
                    yIndex++;
                    if (yIndex == b.numRows - 1) {
                        break;
                    }
                }
                
                //if the top circle is already filled, do nothing and return
                if (yIndex == 0 && b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
                    return;
                }
                
                //set the selected circle's state to current turn value (1 or 2)
                
                b.getGameGridCircle(xIndex, yIndex).setState(b.getTurn());
		b.incrementMoveCounter();
		System.out.println("Move Counter: " + b.getMoveCounter());
		IntPair spotOnBoard = new IntPair(xIndex, yIndex);
		movesList.push(spotOnBoard);

                //change turns
                if (b.getTurn() == 1) {
                    b.setTurn(2);
                }
                else {
                    b.setTurn(1);
                }
                
                //repaint after every mouseClick
                b.repaint();
                
                b.setDrawCounter(b.getDrawCounter()+1);
                
            }
            
            // single player easy
            else{
                
                b.setSinglePlayer(true);
                if (b.getTurn() == 1){
                    xIndex = e.getX()/100;
                    yIndex = 0;
                    
                    
                    while(b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)
                    {
                        yIndex++;
                        if (yIndex == b.numRows - 1) {
                            break;
                        }
                    }
                    
                    //if the top circle is already filled, do nothing and return
                    if (yIndex == 0 && b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
                        return;
                    }
                    
                    //set the selected circle's state to current turn value (1 or 2)
                    
                    b.getGameGridCircle(xIndex, yIndex).setState(b.getTurn());
		    b.incrementMoveCounter();
		    System.out.println("Move Counter: " + b.getMoveCounter());
		    IntPair spotOnBoard = new IntPair(xIndex, yIndex);
		    movesList.push( spotOnBoard);

                    //change turns
                    b.setTurn(2);
                    
                    //repaint after every mouseClick
                    b.repaint();
                    
                    b.setDrawCounter(b.getDrawCounter()+1);
                    
                    
                    //Make a automatic mouse click to start the Computer Move
                    try {
                        // Thread.sleep(1000);
                        Robot r = new Robot();
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);
                        
                    }catch (AWTException ex){
                        System.out.println("didn't work");
                    }
                    
                    
                }
                else {
                    // retrieve a Random computer move
                    // generate a delay to slow computer down
                    if (gameMode == 2){
                        try{
                            Thread.sleep(500);
                            SinglePlayerEasy.randomMove(b); //Generate a Random Move
			    b.incrementMoveCounter();
			    System.out.println("Move Counter: " + b.getMoveCounter());
                        }catch (InterruptedException ex1){
                            System.out.println("Broken Thread");
                        }
                    
                    }
                    else if (gameMode == 3){
                        //retrieve an advanced computer move
                        //generate a delay to slow computer down
                        try{
                            Thread.sleep(500);
                            SinglePlayerAdvanced.AdvancedComputerMove(b);
			    b.incrementMoveCounter();
			    System.out.println("Move Counter: " + b.getMoveCounter());
                        }catch (InterruptedException ex1){
                            System.out.println("Broken Thread");
                        }
                    }// end else if (gameMode == 3)
                
                }// end else
            }// end else
        }// end Method
        
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
 
    
    //getters and Setters
    public int getGameMode(){
        return gameMode;
    }
    
    public void setGameMode(int gMode){
        gameMode = gMode;
    }
    
    
    
}// end of startScreen Class
