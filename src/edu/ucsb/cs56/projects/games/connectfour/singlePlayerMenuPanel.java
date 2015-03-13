package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/** singlePlayerMenu Panel uses swing gui to represent the single player Menu
 */
public class singlePlayerMenuPanel extends JPanel{
    //Instance variables
    private JButton singlePlayerEasy;
    private JButton singlePlayerAdvanced;
    AePlayWave music1;
    
    //constructor
    public singlePlayerMenuPanel(startScreen2 ss){
        super ();//calls jpanel constructor
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        //creates a Easy button and and a listner 
        singlePlayerEasy = new JButton ("Easy");
        singlePlayerEasy.addActionListener(new singlePlayerEasyListener(ss) );
        singlePlayerEasy.setFont(BFont);
        
	//create a Advanced button and a listner
        singlePlayerAdvanced = new JButton ("Advanced");
        singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener(ss) );
        singlePlayerAdvanced.setFont(BFont);
        
	//adds buttons to the panel
        this.add(singlePlayerEasy);
        this.add(singlePlayerAdvanced);
    }
    
    //easy button listner 
    class singlePlayerEasyListener implements ActionListener {
        private startScreen2 ss1;

	//constructor
        singlePlayerEasyListener(final startScreen2 ss){
            ss1 = ss;
        }
	//if button is clicked, game mode is 2 and the game is launched
        public void actionPerformed(ActionEvent event){
            ss1.setGameMode(2);
            ss1.launchGame();
	    music1 = new AePlayWave("ConnectFourMusic.wav");
	    music1.start();
        }
    }
    
    //advanced button listner
    class singlePlayerAdvancedListener implements ActionListener {
        private startScreen2 ss1;

	//constructor
        singlePlayerAdvancedListener(final startScreen2 ss){
            ss1 = ss;
        }
	//if button is clicked, set game mode to 3 and lauch game
        public void actionPerformed(ActionEvent event){
            ss1.setGameMode(3);
            ss1.launchGame();
	    music1 = new AePlayWave("ConnectFourMusic.wav");
	    music1.start();
            
        }
    }
}
