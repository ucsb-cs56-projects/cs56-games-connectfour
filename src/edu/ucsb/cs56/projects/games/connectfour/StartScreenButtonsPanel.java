package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// A JPanel to Layout the Buttons in Start Menu

public class StartScreenButtonsPanel extends JPanel{
    
    private JButton MPButton; // Multi Player Button
    private JButton SPButton; // Single Player Button
    private JButton ExitButton; // Exit Button
    private JButton ruleButton; // Button to show rules
    
    public StartScreenButtonsPanel(startScreen2 ss){
        super();
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        
        MPButton = new JButton ("Multiplayer!");
        MPButton.addActionListener(new MPButtonListener(ss));
        MPButton.setFont(BFont);
        
        SPButton = new JButton ("Single Player");
        SPButton.addActionListener(new SPButtonListener(ss));
        SPButton.setFont(BFont);
        
        ruleButton = new JButton ("Rules");
        ruleButton.addActionListener(new ruleButtonListener());
        ruleButton.setFont(BFont);
        
        ExitButton = new JButton ("Exit");
        ExitButton.addActionListener(new ExitButtonListener(ss));
        ExitButton.setFont(BFont);
        
        
        
        this.add(SPButton);
        this.add(MPButton);
        this.add(ruleButton);
        this.add(ExitButton);
        
    }
 
    
    class MPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        MPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            ss1.setGameMode(1);
            ss1.launchGame();
        }
    }
    
    class SPButtonListener implements ActionListener {
        private startScreen2 ss1;
        
        SPButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            System.out.println("Single Player Mode!");
            ss1.loadSinglePlayerMenu();
            
        }
    }
    
    class ruleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
           Frame frame = new Frame();
	   JOptionPane.showMessageDialog(frame, "Blah BLah blah");
        }
    }
    
    class ExitButtonListener implements ActionListener {
        private startScreen2 ss1;
        ExitButtonListener(final startScreen2 ss){
            ss1 = ss;
        }
        public void actionPerformed(ActionEvent event) {
            
            ss1.setVisible(false);
            ss1.dispose();
        }
        
    }
}
