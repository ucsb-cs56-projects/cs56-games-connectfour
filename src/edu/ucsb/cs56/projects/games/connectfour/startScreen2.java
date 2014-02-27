package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
    private static inGameMenuPanel inGameMenuP;
    
    // Launch game
    public static void main (String [] args){
        JFrame frame = new startScreen2();
     
    }
    
    // initial screen when program is executed
    public startScreen2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(menu_width,menu_height);
        this.setResizable(false);
        ss = new StartScreenButtonsPanel();
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
        SPMenu = new singlePlayerMenuPanel();
        this.add(SPMenu);
        this.revalidate();
        
        
    }
    
    public void BackToStartScreen(){
        if (b != null)
            remove(b);
        if (inGameMenuP != null)
            remove(inGameMenuP);
        
        this.setSize(menu_width,menu_height);
        if (SPMenu != null)
            this.remove(SPMenu);
        
        this.add(ss);
        repaint();
        this.revalidate();
        
    }
    
    public void launchGame(){
        
        System.out.println("Game has started!");
        this.setSize(frame_width,frame_height);
	// remove start button
	//  this.remove(SPButton);
	//  this.remove(MPButton);
        
        this.remove(ss);
        if (SPMenu != null)
            this.remove(SPMenu);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        
       
        inGameMenuP = new inGameMenuPanel();
        b = new Board();
        
        this.add(b);
        this.add(inGameMenuP);
        this.revalidate();
        this.repaint();
        
        
    }
    
    // remove the existing board
    // and make a new one
    public void relaunchGame(){
        
        this.remove(b);
        this.remove(inGameMenuP);
        
        this.repaint();
        System.out.println("Game has started!");
        this.setSize(frame_width,frame_height);
        if (SPMenu != null)
            this.remove(SPMenu);
        //this.remove(ss);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        
        
        inGameMenuP = new inGameMenuPanel();
        b = new Board();
        
        this.add(b);
        this.add(inGameMenuP);
        this.revalidate();
        this.repaint();
        
        
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
            else if (gameMode == 2){
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
                        
		    //change turns
		    b.setTurn(2);
                        
		    //repaint after every mouseClick
		    b.repaint();
                        
		    b.setDrawCounter(b.getDrawCounter()+1);
                    
                                        
		    //Make a automatic mouse click to start the Computer Move
		    try {
			Robot r = new Robot();
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
                        
		    }catch (AWTException ex){
			System.out.println("didn't work");
		    }

                        
		}
		else {
                    // retrieve a Random computer move    
		    b.simpleComputerMove();
		}
            
            }
            
            //single player advanced
            else if (gameMode == 3) {
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
                    
                    //change turns
                    b.setTurn(2);
                    
                    //repaint after every mouseClick
                    b.repaint();
                    
                    b.setDrawCounter(b.getDrawCounter()+1);
                    
                    
                    //Make a automatic mouse click
		    // to start the Computer Move
                    try {
                        Robot r = new Robot();
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);
                        
                    }catch (AWTException ex){
                        System.out.println("generate robot didn't work");
                    }
                    
                    
                }
                else {
                    // retrieve an advanced Computer move
                    b.AdvancedComputerMove();
                }

            }
        }
        
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

    // When the main Menu button is pressed
    // return back to the startScreen
    class mainMenuButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            BackToStartScreen();
            remove(b);
            remove(inGameMenuP);
        }
    }
    
  
    
    // A JPanel to Layout the Buttons in Start Menu
    
    public class StartScreenButtonsPanel extends JPanel{
        
        private JButton MPButton;  // Multi Player Button
        private JButton SPButton;  // Single Player Button
        private JButton ExitButton;  // Exit Button
        private JButton ruleButton;  // Button to show rules
        
        public StartScreenButtonsPanel(){
            super();
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
            
            MPButton = new JButton ("Multiplayer!");
            MPButton.addActionListener(new MPButtonListener());
            MPButton.setFont(BFont);
            
            SPButton = new JButton ("Single Player");
            SPButton.addActionListener(new SPButtonListener());
            SPButton.setFont(BFont);
            
            ruleButton = new JButton ("Rules");
	    ruleButton.addActionListener(new ruleButtonListener());
	    ruleButton.setFont(BFont);

	    ExitButton = new JButton ("Exit");
            ExitButton.addActionListener(new ExitButtonListener());
            ExitButton.setFont(BFont);

	    
            
            this.add(SPButton);
            this.add(MPButton);
	    this.add(ruleButton);
            this.add(ExitButton);
            
        }

	/*
	public void displayRules(Graphics g){
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Times", font.REGULAR, 18));
	    g.drawString("1.Choose a Column to Place a Circle in.\n2. Try to get Four identical circles in a row.");

	}
	*/
        
        class MPButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                gameMode = 1;
                launchGame();
            }
        }
        
        class SPButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Single Player Mode!");
		//        b.setSinglePlayer(true);
                loadSinglePlayerMenu();
		//   launchGame();
            }
        }

	class ruleButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
		//   displayRules(g); 
            }
        }
        
        class ExitButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                dispose();
            }
            
        }
        
        
        
        
    }
    
    //Upon Choosing Single Player, This will be the Panel that will show up

    public class singlePlayerMenuPanel extends JPanel{
        private JButton singlePlayerEasy;
        private JButton singlePlayerAdvanced;
        
        public singlePlayerMenuPanel(){
            super ();
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
            
            singlePlayerEasy = new JButton ("Easy");
            singlePlayerEasy.addActionListener(new singlePlayerEasyListener() );
            singlePlayerEasy.setFont(BFont);
            
            singlePlayerAdvanced = new JButton ("Advanced");
            singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener() );
            singlePlayerAdvanced.setFont(BFont);
            
            this.add(singlePlayerEasy);
            this.add(singlePlayerAdvanced);
        }
        
        class singlePlayerEasyListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
                gameMode = 2;
                launchGame();
            }
        }
        
        class singlePlayerAdvancedListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
                gameMode = 3;
           
            }
        }
    }
    
    
    // Panel for Buttons next to Connect Four Game Board
    
    public class inGameMenuPanel extends JPanel{
        private JButton mainMButton;  // main Menu Button
        private JButton restartButton;  // restart Button
        private JButton exitButton;   // exitButton
	
        public inGameMenuPanel(){
            super ();
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            Font BFont = new Font ("Comic Sans MS", Font.BOLD, 22);
        
	    // Create a 
	    // main button
	    // restart button
	    // exit Button
            mainMButton = new JButton ("Main Menu");
            mainMButton.addActionListener(new mainMenuButtonListener());
            mainMButton.setFont(BFont);
        
            restartButton = new JButton ("Restart");
            restartButton.addActionListener(new restartButtonListener());
            restartButton.setFont(BFont);
        
            exitButton = new JButton ("Exit");
            exitButton.addActionListener(new exitButtonListener());
            exitButton.setFont(BFont);
        
	    
        
            this.add(mainMButton);
            this.add(restartButton);
	    
            this.add(exitButton);

        }
	
	// Listeners for Buttons in Panel
        
	// when restart Button is pressed
	// relaunch Game
        class restartButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
                relaunchGame();
            }
        }// end of RestartButtonListener Class

	// Navigate back to startScreen when this button is pressed
        class mainMenuButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
		BackToStartScreen();                
            }
        }// end of mainMenuButtonListener Class
	
	// when exit button is pressed 
	// make the screen no longer visible, and stop execution
        class exitButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent event){
		setVisible(false);
                dispose();
            }
        }// end of exitButtonListener Class
    }// end of inGameMenuPanel Class
    
}// end of startScreen Class

