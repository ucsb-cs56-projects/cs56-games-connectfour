package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// Panel for telling whose turn it is and displaying it.

/**
   Class for the panel in player color selection screens.
 */

public class namePanel extends JPanel{
    private JLabel enterName; // Textfield indicating whose turn it is
    private JButton saveButton;
    public JTextField nameText;
    public String savedName;

    
    /**
       Constructor for inGameMenuPanel
       @param ss startScreen2 
     */
    
    public namePanel(startScreen2 ss){
	super ();
	
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //this.setMaximumSize(new Dimension(100,650));
	Font BFont = new Font ("Comic Sans MS", Font.BOLD, 22);
	Font smallerBFont = new Font("Comic Sans MS", Font.BOLD, 15);
        

	enterName = new JLabel("Enter Name: ");

	nameText = new JTextField("");
	nameText.setFocusable(true);
	nameText.requestFocus();

	saveButton = new JButton ("SAVE");
        saveButton.addActionListener(new saveButtonListener(ss));
        saveButton.setFont(smallerBFont);
        
	
	// this.add(Box.createRigidArea(new Dimension(0,50)));
	this.add(enterName);
	this.add(nameText);
	this.add(saveButton);
        
    }

    /**
       Listener class for the save button
    */
    class saveButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        saveButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        
        public void actionPerformed(ActionEvent event){
	    savedName = nameText.getText();
	    nameText.setText("");
        }
    }

    public String getName() {return savedName;}
}
    
