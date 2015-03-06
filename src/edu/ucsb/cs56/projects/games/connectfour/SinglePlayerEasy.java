package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
   Single player easy difficult class.  
 */
class SinglePlayerEasy {

    
    //Automatically Generate a Random Computer Move
    // For Easy Mode
    
    /**
       Method that generates a random move on the board and returns an IntPair of the spot chosen
       @param b board on which the spot is to be done
       @return IntPair the IntPair of the spot randomly chosen.
     */
    public static IntPair randomMove(Board b){
        Random rand = new Random();
	int xIndex = rand.nextInt(7);
	int yIndex = 0;
	if (!b.getGameOver()){    //make sure game is not already over
            
        
            // make sure random column is not already full
            while (b.getGameGridCircle(xIndex,yIndex).getState() != 0) {
                xIndex = (xIndex + 1)%7;
            }
            //find the lowest empty slot in the chosen column
            //Place a circle there
            while(b.getGameGridCircle(xIndex, yIndex+1).getState() == 0){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }
        
            b.getGameGridCircle(xIndex,yIndex).setState( b.getPlayer2State() );
            b.setTurn(1);
            b.repaint();
            b.setDrawCounter(b.getDrawCounter() + 1);
        }
	return new IntPair(xIndex, yIndex);
    }

}
