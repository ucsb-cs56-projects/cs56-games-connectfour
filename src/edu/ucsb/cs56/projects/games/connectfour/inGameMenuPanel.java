package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// Panel for Buttons next to Connect Four Game Board

public class inGameMenuPanel extends JPanel{
    //Instance variables
    private JButton mainMButton; // main Menu Button
    private JButton restartButton; // restart Button
    private JButton exitButton; // exitButton
    private JButton musicButton; //musicButton
    
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
	
	//inserted a music off/on
       	musicButton = new JButton ("Music");
	//  musicButton.addActionListener(new musicButtonListener(ss));
	musicButton.setFont(BFont);
        
        
        
        this.add(mainMButton);
        this.add(restartButton);
        this.add(exitButton);
	//added music button to jframe
       	this.add(musicButton);
    }
    
    // Listeners for Buttons in Panel
    
    // when restart Button is pressed
    // relaunch Game
    class restartButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        restartButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.launchGame();
        }
    }// end of RestartButtonListener Class

    
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

    // when music button is pressed
    // make the music turn on or off.
     class musicButtonListener implements ActionListener {
        private Sound ss1;
        
        musicButtonListener(final Sound ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
            ss1.music();
           
        }
     }// end of musicButtonListener Class*/



}// end of inGameMenuPanel Class


