package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class Player2ColorSelectScreen extends JPanel{
    
    private JButton blackButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton brownButton;
    private JButton pinkButton;
    private JButton redButton;
    private JButton yellowButton;
    private JTextField player2SelectText;
    
    public Player2ColorSelectScreen(startScreen2 ss, int stateToNotShow){
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
    
	// Create and add player 2 textfield
	
	if (stateToNotShow != 1) {
	    this.add(redButton);
	}
	if (stateToNotShow != 2) {
	    this.add(yellowButton);
	}
        if (stateToNotShow != 4) {
	    this.add(blackButton);
	}

        if (stateToNotShow != 5) {
	    this.add(blueButton);
	}
	
	if (stateToNotShow != 6) {
	    this.add(magentaButton);
	}
	
	if (stateToNotShow != 7) {
	    this.add(brownButton);
	}
	
	if (stateToNotShow != 8) {
	    this.add(pinkButton);
	}
	
    }
    
    // Create listeners for the color buttons

    class blackButtonListener implements ActionListener {
        private startScreen2 ss1;
        blackButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(4);
	    ss1.launchGame();
        }
    }
    
    class blueButtonListener implements ActionListener {
        private startScreen2 ss1;
        blueButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(5);
	    ss1.launchGame();
        }
    }

    class magentaButtonListener implements ActionListener {
        private startScreen2 ss1;
        magentaButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(6);
	    ss1.launchGame();
        }
    }

    class brownButtonListener implements ActionListener {
        private startScreen2 ss1;
        brownButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(7);
	    ss1.launchGame();
        }
    }

    class pinkButtonListener implements ActionListener {
        private startScreen2 ss1;
        pinkButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(8);
	    ss1.launchGame();
        }
    }

    class redButtonListener implements ActionListener {
        private startScreen2 ss1;
        redButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(1);
	    ss1.launchGame();
        }
    }

    class yellowButtonListener implements ActionListener {
        private startScreen2 ss1;
        yellowButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.setPlayer2ColorState(2);
	    ss1.launchGame();
        }
    }

}
