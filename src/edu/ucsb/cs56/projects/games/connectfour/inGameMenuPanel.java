package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

/**
 * inGameMenuPanel creates a JPanel and three buttons and then adds them.
 * The three buttons are as follows:
 * mainButton
 * restartButton
 * exitButton
 */

public class inGameMenuPanel extends JPanel{
    //Instance variables
    private JButton mainMButton; // main Menu Button
    private JButton restartButton; // restart Button
    private JButton exitButton; // exitButton
   


    
    public inGameMenuPanel(startScreen2 ss){

        super ();//Calls constructor of JPanel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font ("Comic Sans MS", Font.BOLD, 22);

	
        
        // Create a
        // main button
        // restart button
        // exit Button
        mainMButton = new JButton ("Main Menu");
        mainMButton.addActionListener(new mainMenuButtonListener(ss));
        mainMButton.setFont(BFont);
        
        restartButton = new JButton ("Restart");
        restartButton.addActionListener(new restartButtonListener(ss));
        restartButton.setFont(BFont);
        
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(new exitButtonListener(ss));
        exitButton.setFont(BFont);
      
        //adds buttons
        this.add(mainMButton);
        this.add(restartButton);
        this.add(exitButton);
    }

    
    // Listeners for Buttons in Panel
    /**
     * restartButtonListener is the button listener for the restart button.
     * When restart button is pressed, the game is relaunched.
     * 
     */
    class restartButtonListener implements ActionListener {
        private startScreen2 ss1;

        /**
	 * Constructor of this class.
	 * @param ss argument to initialize a final startScreen2 object which
	 * contains the launchGame method.
	 */
        restartButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.launchGame();
        }
    }// end of RestartButtonListener Class


    /**
     * mainMenuButtonListener is the button listener for the main menu  button.
     * When main menu button is pressed, one navigates back to the main menu
     *  screen.
     */
    class mainMenuButtonListener implements ActionListener {
        private startScreen2 ss1;
        /**
	 * Constructor of this class.
	 * @param ss argument to initialize a final startScreen2 object which
	 * contains the BackToStartScreen method.
	 */   
        mainMenuButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.BackToStartScreen();
	    
        }
    }// end of mainMenuButtonListener Class

    /**
     * ecitButtonListener is the button listener for the exit button.
     * When exit button is pressed, the main screen is no longer visible and the
     * execution stops
     */
    class exitButtonListener implements ActionListener {
        private startScreen2 ss1;

        /**
	 * Constructor of this class.
	 * @param ss argument to initialize a final startScreen2 object which
	 * contains the setVisible and dispose methods.
	 */
        
        exitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.setVisible(false);
            ss1.dispose();
        }
    }// end of exitButtonListener Class

    
}// end of inGameMenuPanel Class


