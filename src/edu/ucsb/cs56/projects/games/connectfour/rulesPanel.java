package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class rulesPanel extends JPanel{
    
    private JButton mainMenuButton;
    private JTextArea rulesTextArea;
    private JScrollPane scrollPane;
    // Right now there's an error where if text is outside of the pane it 
    // can't be seen. Need to add a scrollbar
    private String rulesTextString = " \n \n \n \n \n \n hello"; 

    public rulesPanel(startScreen2 ss){
        super ();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
        mainMenuButton = new JButton("Main Menu");
	mainMenuButton.addActionListener( new mainMenuButtonListener(ss) );
	mainMenuButton.setFont(BFont);

	rulesTextArea = new JTextArea(5, 20);
	scrollPane = new JScrollPane(rulesTextArea);
	rulesTextArea.setEditable(false);
	rulesTextArea.append(rulesTextString);
        
	this.add(mainMenuButton);
	this.add(rulesTextArea);
    }
    
    class mainMenuButtonListener implements ActionListener {
	private startScreen2 ss1;
	mainMenuButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event){
            ss1.BackToStartScreen();
        }

    }

  
}
