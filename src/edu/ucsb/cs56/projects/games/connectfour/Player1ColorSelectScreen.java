package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class Player1ColorSelectScreen extends JPanel{
    
    private JButton blackButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton orangeButton;
    private JButton pinkButton;
    private JButton redButton;
    private JButton yellowButton;
    private JTextField player1SelectText = "Player 1 Color";
    
    public singlePlayerMenuPanel(startScreen2 ss){
        super ();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
	blackButton = new JButton ("Black");
	blackButton.addActionListener(new blackButtonListener(ss));
	blackButton.setFont(BFont);

	blueButton = new JButton ("Blue");
	blueButton.addActionListener(new blueButtonListener(ss));
	blueButton.setFont(BFont);

	magentaButton = new JButton ("Magenta");
	magentaButton.addActionListener(new magentaButtonListener(ss));
	magentaButton.setFont(BFont);

	orangeButton = new JButton ("Orange");
	orangeButton.addActionListener(new orangeButtonListener(ss));
	orangeButton.setFont(BFont);

	pinkButton = new JButton ("Pink");
	pinkButton.addActionListener(new pinkButtonListener(ss));
	pinkButton.setFont(BFont);

	redButton = new JButton ("Red");
	redButton.addActionListener(new redButtonListener(ss));
	redButton.setFont(BFont);

	yellowButton = new JButton ("Yellow");
	yellowButton.addActionListener(new yellowButtonListener(ss));
	yellowButton.setFont(BFont);
        
	this.add(blackButton);
	this.add(blueButton);
	this.add(magentaButton);
	this.add(orangeButton);
	this.add(pinkButton);
	this.add(redButton);
	this.add(yellowButton);
        this.add(singlePlayerEasy);
        this.add(singlePlayerAdvanced);
    }
    
    // Create listeners for the color buttons

    class singlePlayerEasyListener implements ActionListener {
        private startScreen2 ss1;
        singlePlayerEasyListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setGameMode(2);
            ss1.launchGame();
        }
    }
    
    class singlePlayerAdvancedListener implements ActionListener {
        private startScreen2 ss1;
        singlePlayerAdvancedListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setGameMode(3);
            ss1.launchGame();
            
        }
    }
}
