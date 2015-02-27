package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class SinglePlayerAdvanced {

    
    //Check if possibility for player to win
    //If so, block spot. If not, random move
    // For Advanced Mode
    
    public static IntPair AdvancedComputerMove(Board b){
        Random rand = new Random();
	int xIndex = 0;
	int yIndex = 0;
	int weight = 0;
	if (!b.getGameOver()){    //make sure game is not already over

            




//Horizontal left to right
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                
                int curr = b.getGameGridCircle(col, row).getState();

                if (curr > 0
                    && curr == b.getGameGridCircle(col+1, row).getState() 
                    && curr == b.getGameGridCircle(col+2, row).getState() 
		    && (b.getGameGridCircle(col+3, row).getState() == 0) ) 
                {
 	            xIndex = col + 3;
	            yIndex = row;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }

//Horizontal right to left
        for (int row = 0; row < 6; row++) {
            for (int col = 6; col > 2; col--) {
                
                int curr = b.getGameGridCircle(col, row).getState();

                if (curr > 0
                    && curr == b.getGameGridCircle(col-1, row).getState() 
                    && curr == b.getGameGridCircle(col-2, row).getState() 
		    && (b.getGameGridCircle(col-3, row).getState() == 0) ) 
                {
	            xIndex = col - 3;
	            yIndex = row;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }
        
//vertical
        for (int col = 0; col < 7; col++) {
            for (int row = 5; row > 2; row--) {
                int curr = b.getGameGridCircle(col, row).getState();
                if (curr > 0 
                    && curr == b.getGameGridCircle(col, row-1).getState() 
                    && curr == b.getGameGridCircle(col, row-2).getState()
		    && (b.getGameGridCircle(col, row-3).getState() == 0) )
                {
	            xIndex = col;
	            yIndex = row - 3;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }
        
        
// diagonal check upper left to lower right, left to right
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 3; row++) {
                int curr = b.getGameGridCircle(col, row).getState();
                if (curr > 0
                    && curr == b.getGameGridCircle(col+1, row+1).getState() 
                    && curr == b.getGameGridCircle(col+2, row+2).getState()
		    && (b.getGameGridCircle(col+3, row+3).getState() == 0) )
                {
                    xIndex = col + 3;
                    yIndex = row + 3;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }

// diagonal check upper left to lower right, right to left
        for (int col = 6; col > 2; col--) {
            for (int row = 5; row > 2; row--) {
                int curr = b.getGameGridCircle(col, row).getState();
                if (curr > 0
                    && curr == b.getGameGridCircle(col-1, row-1).getState()
                    && curr == b.getGameGridCircle(col-2, row-2).getState()
		    && (b.getGameGridCircle(col-3, row-3).getState() == 0) )
                {
                    xIndex = col - 3;
                    yIndex = row - 3;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }
        
// diagonal upper right to lower left, left to right
        for (int col = 6; col >= 3; col--) {
            for (int row = 0; row < 3; row++) {
                int curr = b.getGameGridCircle(col, row).getState();
                if (curr > 0
                    && curr == b.getGameGridCircle(col-1, row+1).getState() 
                    && curr == b.getGameGridCircle(col-2, row+2).getState()
		    && (b.getGameGridCircle(col-3, row+3).getState() == 0) ) 
                {
                    xIndex = col - 3;
                    yIndex = row + 3;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }


// diagonal upper right to lower left, right to left
        for (int col = 0; col < 4; col++) {
            for (int row = 5; row > 2; row--) {
                int curr = b.getGameGridCircle(col, row).getState();
                if (curr > 0
                    && curr == b.getGameGridCircle(col+1, row-1).getState() 
                    && curr == b.getGameGridCircle(col+2, row-2).getState()
		    && (b.getGameGridCircle(col+3, row-3).getState() == 0) ) 
                {
                    xIndex = col + 3;
                    yIndex = row - 3;

            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }

		    weight = 1;
                    break;
                }
            }
        }



	if(weight == 0)
	{
		xIndex = rand.nextInt(7);

            // make sure random column is not already full
            while (b.getGameGridCircle(xIndex,yIndex).getState() != 0) {
                xIndex = (xIndex + 1)%7;
            }
            //find the lowest empty slot in the chosen column
            //Place a circle there
            while((yIndex != b.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex+1).getState() == 0)){
                yIndex++;
                if (yIndex == b.numRows - 1) {
                    break;
                }
            }
    
	}


            b.getGameGridCircle(xIndex,yIndex).setState(b.getTurn());
            b.setTurn(1);
            b.repaint();
            b.setDrawCounter(b.getDrawCounter() + 1);
	    
        }
	return new IntPair(xIndex, yIndex);
    }

}





