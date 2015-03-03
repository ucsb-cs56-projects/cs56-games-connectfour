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
    private String rulesTextString = "RULES" + 
	"\n\n*GamePlay" +
	"\n- First to get 4 of their color in a row wins \n  (Diagonal, horizontal, or vertical)." +
	     " \n  If no one wins then the game is declared a Draw." +
	"\n- For Multiplayer: player 1 is red, player 2 is yellow.\n  The undo button takes away 1 move." + 
	"\n- For Singleplayer: the user goes first and is red, \n  the computer goes 2nd and is yellow." +
	     "\n  The undo button takes away 2 moves (the user's and the computer's)." + 
 	"\n\n*Features " + 
	"\n- Undo button" + 
	"\n- Restart game button" +
	"\n- Main menu button" + 
	"\n- Exit program button"; 

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
	rulesTextArea.setLineWrap(true);
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
