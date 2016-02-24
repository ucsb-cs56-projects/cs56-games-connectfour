package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class Player1ColorSelectScreen extends JPanel{
    
    private JButton blackButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton brownButton;
    private JButton pinkButton;
    private JButton redButton;
    private JButton yellowButton;
    private JTextField player1SelectText;
    
    public Player1ColorSelectScreen(startScreen2 ss){
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

	brownButton = new JButton ("Brown");
	brownButton.addActionListener(new brownButtonListener(ss));
	brownButton.setFont(BFont);

	pinkButton = new JButton ("Pink");
	pinkButton.addActionListener(new pinkButtonListener(ss));
	pinkButton.setFont(BFont);

	redButton = new JButton ("Red");
	redButton.addActionListener(new redButtonListener(ss));
	redButton.setFont(BFont);

	yellowButton = new JButton ("Yellow");
	yellowButton.addActionListener(new yellowButtonListener(ss));
	yellowButton.setFont(BFont);
    
	// Create and add player 1 textfield
	
	this.add(redButton);
	this.add(yellowButton);
	this.add(blackButton);
	this.add(blueButton);
	this.add(magentaButton);
	this.add(brownButton);
	this.add(pinkButton);
	
    }
    
    // Create listeners for the color buttons

    class blackButtonListener implements ActionListener {
        private startScreen2 ss1;
        blackButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(4);
	          ss1.launchPlayer2ColorSelectScreen();
        }
    }
    
    class blueButtonListener implements ActionListener {
        private startScreen2 ss1;
        blueButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(5);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

    class magentaButtonListener implements ActionListener {
        private startScreen2 ss1;
        magentaButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(6);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

    class brownButtonListener implements ActionListener {
        private startScreen2 ss1;
        brownButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(7);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

    class pinkButtonListener implements ActionListener {
        private startScreen2 ss1;
        pinkButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(8);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

    class redButtonListener implements ActionListener {
        private startScreen2 ss1;
        redButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(1);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

    class yellowButtonListener implements ActionListener {
        private startScreen2 ss1;
        yellowButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer1ColorState(2);
	    ss1.launchPlayer2ColorSelectScreen();
        }
    }

}
