package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
   Board class uses swing gui to represent the Connect 4 game board

   @author Jake Dumont
   @author Heneli Kailahi
   @version Project2, CS56, S13

*/

public class Board extends JPanel {

    public static int numColumns = 6;
    public static int numRows = 7;

    public static int width = 710;
    public static int height = 650;

    public static Circle cc;

    private static ArrayList<Circle> circleHolder;
    private Circle[][] gameGrid;
    private int turn;

    public static JFrame frame;

    
    public static void main(String[] args) {
	
       	frame = new JFrame();;
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(width,height);
	
	frame.add(new Board());
	frame.repaint();
	frame.setVisible(true);


    }

    public Board() {

	circleHolder = new ArrayList<Circle>();
	this.gameGrid = new Circle[numRows][numColumns];
	frame.addMouseListener(new MouseClass());

	for (int i = 0; i < numRows; i++) {
	    for (int j = 0; j < numColumns; j++) {
	        cc = new Circle( i * 100 + 55, j * 100 + 55, 90,90);
   		circleHolder.add(cc);
		gameGrid[i][j] = cc;
	    }
	} 
	
	turn = 1;

    }

    @Override
    public void paint(Graphics g) {
	for (Circle[] circles: gameGrid) {
	    for (Circle circle: circles) {
		circle.draw(g);
	    }
	}
    }


    class MouseClass implements MouseListener {
	private int xIndex;
	private int yIndex;

	public void mouseClicked(MouseEvent e) {
	    xIndex = e.getX() / 100;
	    yIndex = 0;
	    
	    while(gameGrid[xIndex][yIndex + 1].getState() == 0)
	    {
		yIndex++;
		if (yIndex == numColumns -1) {
		    break;
		}
	    }
	    if (yIndex == 0 && gameGrid[xIndex][yIndex].getState() != 0) {
		return;
	    }
	    gameGrid[xIndex][yIndex].setState(turn);

	    if (turn == 1) {
		turn = 2;
	    }
	    else {
		turn = 1; 
	    }

	    repaint();
	        
	}
	
	public void mouseEntered(MouseEvent e) {
	    // TODO Auto-generated method stub
	
	}
    
	
	public void mouseExited(MouseEvent e) {
	    // TODO Auto-generated method stub
	    
	}
	
	public void mousePressed(MouseEvent e) {
	    //TODO Auto-generated method stub
	}
	
	public void mouseReleased(MouseEvent e) {
	    // TODO Auto-generated method stub
	
	}
	
    }	
}
