package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// Panel for telling whose turn it is and displaying it.

/**
   Class for the panel displaying whose turn it is.
 */

public class turnPanel extends JPanel{
    private JTextField whoseTurnTextField; // Textfield indicating whose turn it is
    private String whoseTurnText;
    private static int currentTurn;
    
    /**
       Constructor for inGameMenuPanel
       @param ss startScreen2 
     */
    
    public turnPanel(startScreen2 ss){
	// super ();

	this.setBackground(Color.cyan);
	
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

	whoseTurnTextField = new JTextField("   Turn: " + whoseTurnText, 1);
	whoseTurnTextField.setMaximumSize(new Dimension(200, 30));
	whoseTurnTextField.setFont(smallerBFont);
	whoseTurnTextField.setEditable(false);
	
	this.add(Box.createRigidArea(new Dimension(0,50)));
	this.add(whoseTurnTextField);
        
    }
}
    
