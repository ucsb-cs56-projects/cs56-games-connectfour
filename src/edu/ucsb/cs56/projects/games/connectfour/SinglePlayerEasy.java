package edu.ucsb.cs56.projects.games.connectfour;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class SinglePlayerEasy {

    
    //Automatically Generate a Random Computer Move
    // For Easy Mode
    
    public static void randomMove(Board b){
        if (!b.getGameOver()){    //make sure game is not already over
            Random rand = new Random();
            int xIndex = rand.nextInt(7);
            int yIndex = 0;
        
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
        
            b.getGameGridCircle(xIndex,yIndex).setState(b.getTurn());
            b.setTurn(1);
            b.repaint();
            b.setDrawCounter(b.getDrawCounter() + 1);
        }
    }

}
