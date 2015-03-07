package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// Panel for Buttons next to Connect Four Game Board

/**
   Class for the menu panel shown while the game is played.
 */

public class inGameMenuPanel extends JPanel{
    private JButton mainMButton; // main Menu Button
    private JButton restartButton; // restart Button
    private JButton exitButton; // exitButton
    private JButton undoButton; // undoButton
    private JTextField whoseTurnTextField; // Textfield indicating whose turn it is
    private String whoseTurnText;
    private static int currentTurn;
    
    /**
       Constructor for inGameMenuPanel
       @param ss startScreen2 
     */
    
    public inGameMenuPanel(startScreen2 ss){
        super ();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //this.setMaximumSize(new Dimension(100,650));
	Font BFont = new Font ("Comic Sans MS", Font.BOLD, 22);
	Font smallerBFont = new Font("Comic Sans MS", Font.BOLD, 15);
        
	switch (currentTurn) {
	case 1: whoseTurnText = "Red";
	    break;
	case 2: whoseTurnText = "Yellow";
	    break;
	case 4: whoseTurnText = "Black";
	    break;
	case 5: whoseTurnText = "Blue";
	    break;
	case 6: whoseTurnText = "Magenta";
	    break;
	case 7: whoseTurnText = "Brown";
	    break;
	case 8: whoseTurnText = "Pink";
	    break;
	default: whoseTurnText = "Broken";
	    break;
	}

        // Create a
        // main button
        // restart button
        // exit Button
	// undo button
        mainMButton = new JButton ("Main Menu");
        mainMButton.addActionListener(new mainMenuButtonListener(ss));
        mainMButton.setFont(BFont);
        
        restartButton = new JButton ("Restart");
        restartButton.addActionListener(new restartButtonListener(ss));
        restartButton.setFont(BFont);
        
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(new exitButtonListener(ss));
        exitButton.setFont(BFont);
        
        undoButton = new JButton ("Undo");
	undoButton.addActionListener(new undoButtonListener(ss));
	undoButton.setFont(BFont);

	whoseTurnTextField = new JTextField("   Turn: " + whoseTurnText, 1);
	whoseTurnTextField.setMaximumSize(new Dimension(200, 30));
	whoseTurnTextField.setFont(smallerBFont);
	whoseTurnTextField.setEditable(false);
	
	
	//this.add(Box.createRigidArea(new Dimension(0,50)));
	//this.add(whoseTurnTextField);
	this.add(Box.createRigidArea(new Dimension(0,50)));
	this.add(undoButton);
        this.add(mainMButton);
        this.add(restartButton);
        this.add(exitButton);
        
    }
    
    
    // Listeners for Buttons in Panel
    
    // when restart Button is pressed
    // relaunch Game

    /**
       Listener class for the restart button
     */
    class restartButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        restartButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.launchGame();
        }
    }// end of RestartButtonListener Class
    
    /**
       Listener class for the main menu button
     */
    // Navigate back to startScreen when this button is pressed
    class mainMenuButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        mainMenuButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.BackToStartScreen();
        }
    }// end of mainMenuButtonListener Class
    

    /**
       Listener class for the exit button
     */
    // when exit button is pressed
    // make the screen no longer visible, and stop execution
    class exitButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        exitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.setVisible(false);
            ss1.dispose();
        }
    }// end of exitButtonListener Class

    /**
       Listener class for the undo button
     */
    class undoButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        undoButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.undo();
        }
    }

    public void setCurrentTurn(int turn) {
	currentTurn = turn;
    }

}// end of inGameMenuPanel Class



