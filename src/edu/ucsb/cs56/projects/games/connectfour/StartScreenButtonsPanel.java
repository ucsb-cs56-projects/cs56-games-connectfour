package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * StartScreenButtonsPanel class that will create the JPanel to
 * Layout the Buttons in the Start Menu.
 */
public class StartScreenButtonsPanel extends JPanel{
    
    private JButton MPButton; // Multi Player Button
    private JButton SPButton; // Single Player Button
    private JButton ExitButton; // Exit Button
    private JButton ruleButton; // Button to show rules
    AePlayWave music;
    

    /**
     * StartScreenButtonsPanel is the constructor of this class.
     * It create a JPanel, sets the Layout of the Buttons, creates
     * the Buttons, add them and also their actionListener.
     * @param ss is a main menu object.
     */
    public StartScreenButtonsPanel(startScreen2 ss){
        super(); //calls in the constructor of a JPanel

	//makes buttons be stacked one on top of the other        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Font Type and Size
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
	//Makes Multi player Button
        MPButton = new JButton ("Multiplayer!");
        MPButton.addActionListener(new MPButtonListener(ss));
        MPButton.setFont(BFont);

        //Makes Single Player Button
        SPButton = new JButton ("Single Player");
        SPButton.addActionListener(new SPButtonListener(ss));
        SPButton.setFont(BFont);

        //Makes rule button
        ruleButton = new JButton ("Rules");
        ruleButton.addActionListener(new ruleButtonListener());
        ruleButton.setFont(BFont);

        //makes the exit button
        ExitButton = new JButton ("Exit");
        ExitButton.addActionListener(new ExitButtonListener(ss));
        ExitButton.setFont(BFont);
        
        
        //Adds these buttons to the JPanel
        this.add(SPButton);
        this.add(MPButton);
        this.add(ruleButton);
        this.add(ExitButton);
        
    }
 
    //Makes the Button Listner for the Multi player button   
    /**
     * MPButtonListener class creates the listener for the Multiplayer Button.
     * When the Multiplayer Button is pressed, the game will start in
     * multiplayer mode with background music. 
     */
    class MPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
	/**
	 * MPButtonListener make a copy of the main menu object.
	 * @param ss is a main menu object.
	 */
        MPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
	//when multi player button is clicked, it make game mode be two players
	//and then launches game
	/**
	 * actionPerformed will set game mode to 1(multiplayer mode) and launch 
	 * the game with backround music.
	 * @param event is an ActionEvent.
	 */
	@Override
        public void actionPerformed(ActionEvent event) {
            ss1.setGameMode(1);
            ss1.launchGame();
	    music = new AePlayWave("ConnectFourMusic.wav");
	    music.start();
        }
    }

    //Makes the Button Listner for the Single player button  
    /**
     * SPButtonListener class creates the listener for the Single Player Button.
     * When the Single Player Button is pressed, the Single Player Menu
     * will be displayed.
     */ 
    class SPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
	/**
	 * SPButtonListener make a copy of the main menu object.
	 * @param ss is a main menu object.
	 */
        SPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }

	/**
	 * actionPerformed will first print our "Single Player Mode!"
	 * and then will display the Single Player Menu.
	 * @param event is an ActionEvent.
	 */
	@Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Single Player Mode!");
            ss1.loadSinglePlayerMenu();
            
        }
    }
    
    /**
     * ruleButtonListener class creates the listener for the Rules Button.
     * When the Rules Button is pressed, a dialog message will be displayed
     * with the rules of the game.
     */    
    class ruleButtonListener implements ActionListener {

	/**
	 * actionPerformed will display a message dialog box with the rules
	 * when the Rules Button is clicked.
	 * @param event is an ActionEvent.
	 */
	@Override
        public void actionPerformed(ActionEvent event){
           Frame frame = new Frame();
	   JOptionPane.showMessageDialog(frame, "1) For mulyplayer you decide who goes first, but for singleplayer you will always get the start.\n\n2) The first player clicks one of the clolums and their color checker falls into\n    the lowest of the slots in that column on the board.\n    Then, players alternate turns (or player and AI) dropping checkers into the\n    slots on the board, either trying to build up their strategy to win, or block an opponent.\n\n3) Know how the game works. The object of the game is to get four of your color checkers either\n    vertically, horizontally, or diagonally. By strategizing, a player may try to figure out\n    what their opponent is thinking and then attempt to block their win by dropping\n    a checker in a corresponding slot.");
        }
    }
    
    /**
     * ExitButtonListener class creates the listener for the Exit Button.
     * When the Exit Button is pressed,the game will exit. 
     */
    class ExitButtonListener implements ActionListener {
        private startScreen2 ss1;

	/**
	 * ExitButtonListener makes a copy of the main menu object.
	 * @param ss is a main menu object.
	 */
        ExitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }

	/**
	 * actionPerformed will exit the game when the Exit Button is pressed.
	 * @param event is an ActionEvent.
	 */
	@Override
        public void actionPerformed(ActionEvent event) {
            
            ss1.setVisible(false);
            ss1.dispose();
        }
        
    }
}
