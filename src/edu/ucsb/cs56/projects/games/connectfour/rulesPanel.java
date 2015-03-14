package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/**
   Panel for the rules menu accessed from the Main Menu screen
 */
public class rulesPanel extends JPanel{
    
    private JButton mainMenuButton;
    private JTextArea rulesTextArea;
    private JScrollPane scrollPane;
    private String rulesTextString = "RULES" + 
	"\n\n*GamePlay" +
	"\n- First to get 4 of their color in a row wins \n  (Diagonal, horizontal, or vertical)." +
	     " \n  If no one wins then the game is declared a Draw." +
	"\n- For Multiplayer: player 1 chooses their color first," + 
	"\n  player 2 chooses their color second." +
	"\n  The undo button takes away 1 move." + 
	"\n- For Singleplayer: the user chooses their color first and goes first," +
	" \n  the computer's color is the second color chosen." +
	"\n  The undo button takes away 2 moves (the user's and the computer's)." + 
 	"\n\n*Features " + 
	"\n- Choose colors for the circles" + 
	"\n- Undo button" + 
	"\n- Restart game button" +
	"\n- Main menu button" + 
	"\n- Exit program button"; 

    /**
       Constructor for rulesPanel
       @param ss startScreen2
     */
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

  
}
