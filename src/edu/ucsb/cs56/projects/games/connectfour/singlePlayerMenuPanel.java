package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class singlePlayerMenuPanel extends JPanel{
    
    private JButton singlePlayerEasy;
    private JButton singlePlayerAdvanced;
    
    public singlePlayerMenuPanel(startScreen2 ss){
        super ();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
        singlePlayerEasy = new JButton ("Easy");
        singlePlayerEasy.addActionListener(new singlePlayerEasyListener(ss) );
        singlePlayerEasy.setFont(BFont);
        
        singlePlayerAdvanced = new JButton ("Advanced");
        singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener(ss) );
        singlePlayerAdvanced.setFont(BFont);
        
        this.add(singlePlayerEasy);
        this.add(singlePlayerAdvanced);
    }
    
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
