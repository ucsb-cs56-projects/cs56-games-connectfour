package edu.ucsb.cs56.projects.games.connectfour;

package ConnectFour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


 

public class startScreen2 extends JFrame {
    
  
    
    public static int frame_width = 820;
    public static int frame_height = 650;
    public static Board b;
    private static JButton sButton;
    private static JButton mMButton;
    public static void main (String [] args){
        
            
        JFrame frame = new startScreen2();
     
    }
    
    public startScreen2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frame_width,frame_height);
        
        sButton = new JButton ("Start!");
        sButton.addActionListener(new startButtonListener());
        
        
        
        this.getContentPane().add(BorderLayout.CENTER, sButton);
        this.addMouseListener(new MouseClass());
        this.setVisible(true);

        
    }
    
    public void BackToStartScreen(){
    
        System.out.println("Back TO Main MEnu");
        this.getContentPane().add(BorderLayout.CENTER, sButton);
        this.revalidate();
        
    }
    
    public void launchGame(){
        System.out.println("Game has started!");
        
	// remove start button
        this.remove(sButton);
        
        mMButton = new JButton ("Main Menu!");
        mMButton.addActionListener(new mainMenuButtonListener());
        
        b = new Board();
        this.getContentPane().add(BorderLayout.EAST, mMButton);
        this.getContentPane().add(BorderLayout.CENTER,b);
        this.revalidate();
        this.repaint();
    
        
    }
    
 
    class MouseClass implements MouseListener{
        private int xIndex;
        private int yIndex;
        
        public void mouseClicked(MouseEvent e){
            if (b.getGameOver())
                return;
            
            xIndex = e.getX()/100;
            yIndex = 0;
            
            while(b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)
		{
		    yIndex++;
		    if (yIndex == b.numRows - 1) {
			break;
		    }
		}
            
            //if the top circle is already filled, do nothing and return
            if (yIndex == 0 && b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
                return;
            }
            
            //set the selected circle's state to current turn value (1 or 2)
            b.getGameGridCircle(xIndex, yIndex).setState(b.getTurn());
            
            //change turns
            if (b.getTurn() == 1) {
                b.setTurn(2);
            }
            else {
                b.setTurn(1);
            }
            
            //repaint after every mouseClick
            b.repaint();
            
            b.setDrawCounter(b.getDrawCounter()+1);
            
            
	    System.out.println(b.getGameGridCircle(xIndex,yIndex).getState());
            System.out.println(e.getX());
            System.out.println(e.getY());
            
        }
        
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
        
        /**
         mouseExited is a function in the MouseListener interface
         @param e represents the mouseEvent
	*/
        
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
        
        /**
         mousePressed is a function in the MouseListener interface
         @param e represents the mouseEvent
	*/
        
        public void mousePressed(MouseEvent e) {
            //TODO Auto-generated method stub
        }
        
        /**
         mouseReleased is a function in the MouseListener interface
         @param e represents the mouseEvent
	*/
        
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        
    }
    class startButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            launchGame();
        }
    }
  
    class mainMenuButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            BackToStartScreen();
            remove(b);
            remove(mMButton);
        }
    }
   
}


