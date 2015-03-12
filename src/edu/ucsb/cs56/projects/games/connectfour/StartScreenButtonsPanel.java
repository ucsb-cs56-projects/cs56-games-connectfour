package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// A JPanel to Layout the Buttons in Start Menu

public class StartScreenButtonsPanel extends JPanel{
    
    private JButton MPButton; // Multi Player Button
    private JButton SPButton; // Single Player Button
    private JButton ExitButton; // Exit Button
    private JButton ruleButton; // Button to show rules
    
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
    class MPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
	//constructor
        MPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
	//when multi player button is clicked, it make game mode be two players
	//and then launches game
        public void actionPerformed(ActionEvent event) {
            ss1.setGameMode(1);
            ss1.launchGame();
        }
    }

    //Makes the Button Listner for the Single player button   
    class SPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
	//constructor
        SPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
	//when single player button is clicked, it prints out 
	//"Single Player Mode!" and then loads the single player menu
        public void actionPerformed(ActionEvent event) {
            System.out.println("Single Player Mode!");
            ss1.loadSinglePlayerMenu();
            
        }
    }
    
    //Makes the Button Listner for the rule  button   
    class ruleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
           Frame frame = new Frame();
	   JOptionPane.showMessageDialog(frame, "1) For mulyplayer you decide who goes first, but for singleplayer you will always get the start.\n\n2) The first player clicks one of the clolums and their color checker falls into\n    the lowest of the slots in that column on the board.\n    Then, players alternate turns (or player and AI) dropping checkers into the\n    slots on the board, either trying to build up their strategy to win, or block an opponent.\n\n3) Know how the game works. The object of the game is to get four of your color checkers either\n    vertically, horizontally, or diagonally. By strategizing, a player may try to figure out\n    what their opponent is thinking and then attempt to block their win by dropping\n    a checker in a corresponding slot.");
        }
    }
    
   //Makes the Button Listner for the Exit button   
    class ExitButtonListener implements ActionListener {
        private startScreen2 ss1;
	//constructor
        ExitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
	//when exit button is clicked, it exits game 
        public void actionPerformed(ActionEvent event) {
            
            ss1.setVisible(false);
            ss1.dispose();
        }
        
    }
}
