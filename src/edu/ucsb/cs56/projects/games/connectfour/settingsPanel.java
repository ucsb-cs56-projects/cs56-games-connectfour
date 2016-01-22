package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/**
   Panel for the settings menu accessed from the Main Menu screen
 */
public class settingsPanel extends JPanel{
    
    private JButton mainMenuButton;
    private JCheckBox popOutModeCB;
    private static boolean popOutModeCBIsSelected = false;;

    /**
       Constructor for the settingsPanel
       @param ss startScreen2
     */
    public settingsPanel(startScreen2 ss, boolean popOutModeChecked){
        super ();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
        mainMenuButton = new JButton("Main Menu");
	mainMenuButton.addActionListener( new mainMenuButtonListener(ss) );
	mainMenuButton.setFont(BFont);
	
	popOutModeCBIsSelected = popOutModeChecked;

	popOutModeCB = new JCheckBox("Pop Out Mode", popOutModeCBIsSelected);
	popOutModeCB.addItemListener( new popOutModeCBListener(ss));
	popOutModeCB.setFont(BFont);

	this.add(mainMenuButton);
	this.add(popOutModeCB);
    }
    
    /**
       Listener for the main menu button in the rules page
     */
    class mainMenuButtonListener implements ActionListener {
	private startScreen2 ss1;
	mainMenuButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.BackToStartScreen();
        }

    }

    class popOutModeCBListener implements ItemListener {
	private startScreen2 ss1;
	popOutModeCBListener(final startScreen2 ss){
	    ss1 = ss;
	}
	public void itemStateChanged(ItemEvent event) {
	    if (event.getStateChange() == ItemEvent.SELECTED) 
		ss1.setPopOutModeBool(true);
	    else
		ss1.setPopOutModeBool(false);
	}

    }
    
    
}
